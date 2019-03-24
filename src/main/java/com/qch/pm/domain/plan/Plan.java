package com.qch.pm.domain.plan;

/**
 * @author : qiuchenhao
 * @date : 2019/3/16
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Plan {

    @Id
    @GeneratedValue
    private Long id; //id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date commitDate; //提出日期
    private String commitPerson; //提交人
    private String confirmPerson; //确认人
    private String requirementType; //需求类型
    private String requirementModule; //需求模块

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state; //状态
    @Lob
    private String requirementDescription; //需求描述
    private String developPerson; //开发人员
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date beginDate; //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date endDate; //结束时间
    @Lob
    private String notes; //备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public String getCommitPerson() {
        return commitPerson;
    }

    public void setCommitPerson(String commitPerson) {
        this.commitPerson = commitPerson;
    }

    public String getConfirmPerson() {
        return confirmPerson;
    }

    public void setConfirmPerson(String confirmPerson) {
        this.confirmPerson = confirmPerson;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequirementModule() {
        return requirementModule;
    }

    public void setRequirementModule(String requirementModule) {
        this.requirementModule = requirementModule;
    }

    public String getRequirementDescription() {
        return requirementDescription;
    }

    public void setRequirementDescription(String requirementDescription) {
        this.requirementDescription = requirementDescription;
    }

    public String getDevelopPerson() {
        return developPerson;
    }

    public void setDevelopPerson(String developPerson) {
        this.developPerson = developPerson;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", commitDate=" + commitDate +
                ", commitPerson='" + commitPerson + '\'' +
                ", confirmPerson='" + confirmPerson + '\'' +
                ", requirementType='" + requirementType + '\'' +
                ", requirementModule='" + requirementModule + '\'' +
                ", requirementDescription='" + requirementDescription + '\'' +
                ", developPerson='" + developPerson + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", notes='" + notes + '\'' +
                '}';
    }

}
