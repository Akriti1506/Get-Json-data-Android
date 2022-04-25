
package com.akriti.physicsWallah.Model;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private Integer id;
    private String subj;
    private String profileUrl;
    private String qual;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subj;
    }

    public void setSubject(String subj) {
        this.subj = subj;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getQual() {
        return qual;
    }

    public void setQual(String qual) {
        this.ual = qual;
    }

  
}
