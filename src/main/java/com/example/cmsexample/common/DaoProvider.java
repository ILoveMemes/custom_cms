package com.example.cmsexample.common;

import com.example.cmsexample.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoProvider {

    private AddressDao addressDao;
    private CommonDao commonDao;
    private CustomerDao customerDao;
    private HistoryDao historyDao;
    private LicenseDao licenseDao;
    private MessengerDao messengerDao;
    private PartnerDao partnerDao;
    private PhoneDao phoneDao;
    private RequisiteDao requisiteDao;
    private ServiceDao serviceDao;
    private PictureDao pictureDao;

    public PictureDao getPictureDao() {
        return pictureDao;
    }

    @Autowired
    public void setPictureDao(PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public CommonDao getCommonDao() {
        return commonDao;
    }

    @Autowired
    public void setCommonDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public HistoryDao getHistoryDao() {
        return historyDao;
    }

    @Autowired
    public void setHistoryDao(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    public LicenseDao getLicenseDao() {
        return licenseDao;
    }

    @Autowired
    public void setLicenseDao(LicenseDao licenseDao) {
        this.licenseDao = licenseDao;
    }

    public MessengerDao getMessengerDao() {
        return messengerDao;
    }

    @Autowired
    public void setMessengerDao(MessengerDao messengerDao) {
        this.messengerDao = messengerDao;
    }

    public PartnerDao getPartnerDao() {
        return partnerDao;
    }

    @Autowired
    public void setPartnerDao(PartnerDao partnerDao) {
        this.partnerDao = partnerDao;
    }

    public PhoneDao getPhoneDao() {
        return phoneDao;
    }

    @Autowired
    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public RequisiteDao getRequisiteDao() {
        return requisiteDao;
    }

    @Autowired
    public void setRequisiteDao(RequisiteDao requisiteDao) {
        this.requisiteDao = requisiteDao;
    }

    public ServiceDao getServiceDao() {
        return serviceDao;
    }

    @Autowired
    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }
}
