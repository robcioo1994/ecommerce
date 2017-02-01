import React from 'react'
import {Route, IndexRoute, Redirect} from 'react-router'

import requireAuth from '../utils/requireAuth';

import App from '../../components/App';
import MainContainer from '../../components/MainContainer';
import MainPageView from '../../components/MainPageView';
import SignUpPage from '../../components/signup/SignUpPage';
import LoginPage from '../../components/login/LoginPage';
import ProductListPage from '../../components/productsList/ProductListPage';
import ProductPage from '../../components/product/ProductPage';
import CartPage from '../../components/cart/CartPage';
import NotFoundPage from '../../components/404/NotFoundPage';

// USER PAGE
import UserPage from '../../components/private/userPage/UserPage';
import UserSettingPage from '../../components/private/userPage/settingPage/UserSettingPage';
import MyOrdersPage from '../../components/private/userPage/orderPage/MyOrdersPage';
import UserDashboard from '../../components/private/userPage/userDashbord/UserDashboard';


// ADMIN PAGE
import AdminPage from '../../components/private/admin/AdminPage';
import Dashboard from '../../components/private/admin/dashboard/Dashboard';
import AddNewComponent from '../../components/private/admin/addProduct/AddNewComponent';
import AddNewNotebook from '../../components/private/admin/addProduct/AddNewNotebook';
import AdminSettingPage from '../../components/private/admin/settingPage/AdminSettingPage';

import TestColorPage from '../../components/test/TestColorPage';

export default (
    <Route component={MainContainer}>

        <Route path="/" component={App} >
            <IndexRoute component={MainPageView} />
            <Route path="signup" component={SignUpPage} />
            <Route path="login" component={LoginPage} />

            <Route path="pl/:category" component={ProductListPage} />
            <Route path="p/:id" component={ProductPage} />

            <Route path="cart" component={CartPage} />
            <Route path="test" component={TestColorPage} />
            <Route path="/404" component={NotFoundPage} />
        </Route>

        <Route path="admin" component={AdminPage} >
            <IndexRoute component={Dashboard} />
            <Route path="addNewComponent" component={AddNewComponent} />
            <Route path="addNewNotebook" component={AddNewNotebook} />
            <Route path="setting" component={AdminSettingPage} />
        </Route>


        <Route path="user" component={UserPage} >
            <IndexRoute component={UserDashboard} />
            <Route path="myOrders" component={MyOrdersPage} />
            <Route path="setting" component={UserSettingPage} />
        </Route>


        <Redirect from="/*" to="/404" />
    </Route>
);