package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "STUDENT", indexes = {
        @Index(name = "IDX_STUDENT_ADDRESS", columnList = "ADDRESS_ID")
})
@Entity
public class Student {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "FIO")
    private String fio;

    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "STUDYING_YEAR", length = 2)
    private String studyingYear;

    @Column(name = "MASK")
    private String mask;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "SCHOOL")
    private String school;

    @Column(name = "SCHOOL_LITER", length = 1)
    private String schoolLiter;

    @Column(name = "STUDY_LANG")
    private String studyLang;

    @Column(name = "STATUS")
    private String status;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student")
    private OpenCase openCase;

    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "FULL_AGE")
    private Integer fullAge;

    @Column(name = "SPECIAL_NEEDS")
    private Integer specialNeeds;

    @Column(name = "CONTACT_PHONE")
    private String contactPhone;

    @Composition
    @OneToMany(mappedBy = "student")
    private List<Parent> parents;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "ADDRESS_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    @Composition
    @OneToMany(mappedBy = "student")
    private List<Relative> relative;

    public SchoolMask getMask() {
        return mask == null ? null : SchoolMask.fromId(mask);
    }

    public void setMask(SchoolMask mask) {
        this.mask = mask == null ? null : mask.getId();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSchoolLiter() {
        return schoolLiter;
    }

    public void setSchoolLiter(String schoolLiter) {
        this.schoolLiter = schoolLiter;
    }

    public List<Relative> getRelative() {
        return relative;
    }

    public void setRelative(List<Relative> relative) {
        this.relative = relative;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public SpecialNeedsField getSpecialNeeds() {
        return specialNeeds == null ? null : SpecialNeedsField.fromId(specialNeeds);
    }

    public void setSpecialNeeds(SpecialNeedsField specialNeeds) {
        this.specialNeeds = specialNeeds == null ? null : specialNeeds.getId();
    }

    public Integer getFullAge() {
        return fullAge;
    }

    public void setFullAge(Integer fullAge) {
        this.fullAge = fullAge;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public OpenCase getOpenCase() {
        return openCase;
    }

    public void setOpenCase(OpenCase openCase) {
        this.openCase = openCase;
    }

    public StudyingLangField getStudyLang() {
        return studyLang == null ? null : StudyingLangField.fromId(studyLang);
    }

    public void setStudyLang(StudyingLangField studyLang) {
        this.studyLang = studyLang == null ? null : studyLang.getId();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public StudentStatusField getStatus() {
        return status == null ? null : StudentStatusField.fromId(status);
    }

    public void setStatus(StudentStatusField status) {
        this.status = status == null ? null : status.getId();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStudyingYear() {
        return studyingYear;
    }

    public void setStudyingYear(String studyingYear) {
        this.studyingYear = studyingYear;
    }

    public GenderField getGender() {
        return gender == null ? null : GenderField.fromId(gender);
    }

    public void setGender(GenderField gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}