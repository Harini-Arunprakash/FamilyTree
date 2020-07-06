package com.harinijanani.familytree.domain;

public class FamilyTree {

    private String ownerFirstName;
    private String ownerLastName;
    private String id;
    private String ownerEmail;

    public FamilyTree(String ownerfn, String ownerln, String id, String ownerEmail) {
        ownerFirstName = ownerfn;
        ownerLastName = ownerln;
        this.id = id;
        this.ownerEmail = ownerEmail;

    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
