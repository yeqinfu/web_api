package com.ppandroid.hx;

import java.util.ArrayList;
import java.util.List;
class Entities {
    private String uuid;

    private String type;

    private Long created;

    private Long modified;

    private String username;

    private boolean activated;

    public void setUuid(String uuid){
        this.uuid = uuid;
    }
    public String getUuid(){
        return this.uuid;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setCreated(Long created){
        this.created = created;
    }
    public Long getCreated(){
        return this.created;
    }
    public void setModified(Long modified){
        this.modified = modified;
    }
    public Long getModified(){
        return this.modified;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setActivated(boolean activated){
        this.activated = activated;
    }
    public boolean getActivated(){
        return this.activated;
    }
}


public class HXUserVo
{
    private String action;

    private String application;

    private String path;

    private String uri;

    private List<Entities> entities;

    private Long timestamp;

    private int duration;

    private String organization;

    private String applicationName;

    public void setAction(String action){
        this.action = action;
    }
    public String getAction(){
        return this.action;
    }
    public void setApplication(String application){
        this.application = application;
    }
    public String getApplication(){
        return this.application;
    }
    public void setPath(String path){
        this.path = path;
    }
    public String getPath(){
        return this.path;
    }
    public void setUri(String uri){
        this.uri = uri;
    }
    public String getUri(){
        return this.uri;
    }
    public void setEntities(List<Entities> entities){
        this.entities = entities;
    }
    public List<Entities> getEntities(){
        return this.entities;
    }
    public void setTimestamp(Long timestamp){
        this.timestamp = timestamp;
    }
    public Long getTimestamp(){
        return this.timestamp;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public int getDuration(){
        return this.duration;
    }
    public void setOrganization(String organization){
        this.organization = organization;
    }
    public String getOrganization(){
        return this.organization;
    }
    public void setApplicationName(String applicationName){
        this.applicationName = applicationName;
    }
    public String getApplicationName(){
        return this.applicationName;
    }
}
