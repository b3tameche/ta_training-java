package com.epam.training.achi_tsintsadze.framework.models;

public class Engine {
    private String numberOfInstances;
    private String operatingSystem;
    private String series;
    private String machineType;
    private String gpuType;
    private String gpuNumber;
    private String ssd;
    private String location;
    private String usage;

    public Engine(String instances, String system, String serial, String machine, String gpu, String gpuNumber, String ssd, String location, String usage) {
        this.numberOfInstances = instances;
        this.operatingSystem = system;
        this.series = serial;
        this.machineType = machine;
        this.gpuType = gpu;
        this.gpuNumber = gpuNumber;
        this.ssd = ssd;
        this.location = location;
        this.usage = usage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getGpuNumber() {
        return gpuNumber;
    }

    public void setGpuNumber(String gpuNumber) {
        this.gpuNumber = gpuNumber;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
