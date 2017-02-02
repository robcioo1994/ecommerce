package com.kuba.ecommerce.interfaces;

import com.kuba.ecommerce.exceptions.NullValueException;
import com.kuba.ecommerce.exceptions.ValueNotInUniverseException;
import com.kuba.ecommerce.models.values.FuzzyValue;

interface Norm {

    FuzzyValue getValue(FuzzyValue a, FuzzyValue b) throws ValueNotInUniverseException, NullValueException;
}
