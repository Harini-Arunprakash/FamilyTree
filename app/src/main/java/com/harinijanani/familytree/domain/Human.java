package com.harinijanani.familytree.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Human {

    private String firstName;
    private String lastName;
    private boolean male;
    private Human father;
    private Human mother;
    transient Set<Human> children;
    transient Human marriagePartner;

    public Human() {
        children = new HashSet<>();
    }

    public Human(String firstName, String lastName, boolean male) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.male = male;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isFemale() {
        return !male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        father.addChildrenWithoutSettingParents(this);
    }

    private void setFatherWithoutAddingChild(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.addChildrenWithoutSettingParents(this);
    }

    private void setMotherWithoutAddingChild(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        List<Human> childrenList = new ArrayList<>();
        childrenList.addAll(children);
        return childrenList;
    }

    public void setChildren(List<Human> children) {
        this.children = new HashSet<>(children);
    }

    public void addChildren(Human... children) {
        for (Human child : children) {
            if (male) {
                child.setFatherWithoutAddingChild(this);
            } else {
                child.setMotherWithoutAddingChild(this);
            }
            this.children.add(child);
        }
    }

    private void addChildrenWithoutSettingParents(Human... children) {
        for (Human child : children) {
            this.children.add(child);
        }
    }

    public Human getMarriagePartner() {
        return marriagePartner;
    }

    public boolean setMarriagePartner(Human marriagePartner) {
        if (marriagePartner.isMale() != marriagePartner.isMale()) {
            this.marriagePartner = marriagePartner;
            if (isFemale()) {
                setLastName(marriagePartner.getLastName());
            }
            return true;
        }
        return false;
    }

    public Human[] getGrandFathers() {
        Human[] grandFathers = new Human[2];
        if (mother != null) {
            grandFathers[0] = mother.getFather();
        }
        if(father != null) {
            grandFathers[1] = father.getFather();
        }
        return grandFathers;
    }

    public Human[] getGrandMothers() {
        Human[] grandMothers = new Human[2];
        if (mother != null) {
            grandMothers[0] = mother.getMother();
        }
        if(father != null) {
            grandMothers[1] = father.getMother();
        }
        return grandMothers;
    }

    public List<Human> getSiblings() {
        Set<Human> siblings = new HashSet();
        if (father != null) {
            for (Human child : father.getChildren()) {
                if (child != this) {
                    siblings.add(child);
                }
            }
        }
        if (mother != null) {
            for (Human child : mother.getChildren()) {
                if (child != this) {
                    siblings.add(child);
                }
            }
        }

        List<Human> siblingsList = new ArrayList<>();
        siblingsList.addAll(siblings);
        return siblingsList;
    }

    public List<Human> getSiblingsOfParents() {
        Set<Human> siblings = new HashSet<Human>();
        // get children of grandFather except own father
        for (Human grandFather : getGrandFathers()) {
            if (grandFather != null) {
                for (Human children : grandFather.getChildren()) {
                    if (children != father && children != mother) {
                        siblings.add(children);
                    }
                }
            }
        }

        // get children of grandFather except own father
        for (Human grandMother : getGrandMothers()) {
            if (grandMother != null) {
                for (Human children : grandMother.getChildren()) {
                    if (children != father && children != mother) {
                        siblings.add(children);
                    }
                }
            }
        }

        List <Human> siblingsList = new ArrayList<>();
        siblingsList.addAll(siblings);
        return siblingsList;
    }

    public List<Human> getUncles() {
        List<Human> siblings = new ArrayList<>();
        siblings.addAll(getSiblingsOfParents());

        List<Human> uncles = new ArrayList<Human>();
        for (Human sibling : siblings) {
            if (sibling.isMale()) {
                uncles.add(sibling);
            }
        }

        return uncles;
    }

    public List<Human> getAunts() {
        List<Human> siblings = new ArrayList<>();
        siblings.addAll(getSiblingsOfParents());

        List<Human> aunts = new ArrayList<Human>();
        for (Human sibling : siblings) {
            if (sibling.isFemale()) {
                aunts.add(sibling);
            }
        }

        return aunts;
    }

    public Human getFirstFather() {
        Human currentFather = null;
        if (father != null) {
            currentFather = father;
        }
        while (currentFather.getFather() != null) {
            currentFather = currentFather.getFather();
        }
        return currentFather;
    }
}
