package com.robert.ecommerce.utils.converter;

import com.robert.ecommerce.dto.InputOutputTypesDTO;
import com.robert.ecommerce.dto.FullNotebookDTO;
import com.robert.ecommerce.entity.DescriptionEntity;
import com.robert.ecommerce.entity.ImagesEntity;
import com.robert.ecommerce.entity.InputOutputTypesEntity;
import com.robert.ecommerce.entity.NotebookEntity;
import com.robert.ecommerce.repository.*;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.stream.Collectors;

@Component
public class NotebookConverter extends CustomConverter<FullNotebookDTO, NotebookEntity> {

    @Autowired
    private ProcessorRepository processorRepository;
    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private MemoryRepository memoryRepository;
    @Autowired
    private AdditionalDescriptionRepository descriptionRepository;
    @Autowired
    private HardDiscRepository hardDiscRepository;
    @Autowired
    private DisplayResolutionRepository resolutionRepository;
    @Autowired
    private DisplayTypeRepository displayTypeRepository;
    @Autowired
    private DisplaySizeRepository displaySizeRepository;
    @Autowired
    private GraphicsCartRepository graphicsCartRepository;
    @Autowired
    private OperatingSystemRepository operatingSystemRepository;
    @Autowired
    private InputOutputTypesRepository inputOutputTypesRepository;
    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public NotebookEntity convert(FullNotebookDTO newNotebook, Type<? extends NotebookEntity> type) {
        NotebookEntity notebookEntity = new NotebookEntity();

        notebookEntity.setProducer(producerRepository.findOne(newNotebook.getProducer().getId()));
        notebookEntity.setProductName(newNotebook.getProductName());
        notebookEntity.setPrice(newNotebook.getPrice());

        notebookEntity.setWidth(newNotebook.getWidth());
        notebookEntity.setHeight(newNotebook.getHeight());
        notebookEntity.setDepth(newNotebook.getDepth());
        notebookEntity.setWeight(newNotebook.getWeight());

        notebookEntity.setCpu(processorRepository.findOne(newNotebook.getCpu().getId()));
        notebookEntity.setMemory(memoryRepository.findOne(newNotebook.getMemory().getId()));
        notebookEntity.setMaxMemory(newNotebook.getMaxMemory());
        notebookEntity.setHardDisc(hardDiscRepository.findOne(newNotebook.getHardDisc().getId()));
        notebookEntity.setGpu(graphicsCartRepository.findOne(newNotebook.getGpu().getId()));

        notebookEntity.setDisplayResolution(resolutionRepository.findOne(newNotebook.getDisplayResolution().getId()));
        notebookEntity.setDisplaySize(displaySizeRepository.findOne(newNotebook.getDisplaySize().getId()));
        notebookEntity.setDisplayType(displayTypeRepository.findOne(newNotebook.getDisplayType().getId()));

        notebookEntity.setInputOutputTypes(newNotebook.getInputOutputTypes().stream().map((InputOutputTypesDTO item) -> new InputOutputTypesEntity(item.getId(), item.getInputOutput())).collect(Collectors.toList()));

        notebookEntity.setOperatingSystem(operatingSystemRepository.findOne(newNotebook.getOperatingSystem().getId()));

        notebookEntity.setColor(newNotebook.getColor());
        notebookEntity.setGuarantee(newNotebook.getGuarantee());

        notebookEntity.setFrontImage(Base64.getDecoder().decode(newNotebook.getFrontImage()));

        ArrayList<ImagesEntity> list = new ArrayList<>();
        newNotebook.getImages().forEach(item-> {
            ImagesEntity save = imagesRepository.save(new ImagesEntity(Base64.getDecoder().decode(item.getImage())));
            list.add(save);
        });
        notebookEntity.setImages(list);

        ArrayList<DescriptionEntity> descriptionList = new ArrayList<>();
        newNotebook.getAdditionalDescription().forEach(item-> {
            DescriptionEntity save = descriptionRepository.save(new DescriptionEntity(item.getTitle(), item.getDescription(), Base64.getDecoder().decode(item.getImage())));
            descriptionList.add(save);
        });
        notebookEntity.setAdditionalDescription(descriptionList);

        return notebookEntity;
    }
}
