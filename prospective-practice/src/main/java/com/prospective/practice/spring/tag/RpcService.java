package com.prospective.practice.spring.tag;


/**
 * Created by wanbf on 2018/5/24.
 */
public class RpcService {

    private String contact;

    // 服务名称
    private String serviceName;

    // 服务实现
    private String serviceImplName;

    public RpcService() {

    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceImpl() {
        return serviceImplName;
    }

    public void setServiceImplName(String serviceImplName) {
        this.serviceImplName = serviceImplName;
    }

    @Override
    public String toString() {
        return "RpcService{" +
                "contact='" + contact + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceImplName='" + serviceImplName + '\'' +
                '}';
    }
}
