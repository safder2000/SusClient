package net.suspoocha.susclient.module;

import net.minecraft.client.MinecraftClient;

public class Mod {
    private String name;
    private String discription;
    private int key;
    private  String displayName;
    private Category category;
    private boolean enabled;
protected MinecraftClient mc = MinecraftClient.getInstance();
    public Mod(String name, String discription, Category category) {
        this.name = name;
        this.displayName = name;
        this.discription = discription;
        this.category = category;

    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {

    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void onDisable() {

    }
    public  void onTick(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setEnable(boolean enable) {
        this.enabled = enable;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public String getDiscription() {
        return discription;
    }

    public int getKey() {
        return key;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }


    public enum Category {
        COMBACT("Combact"), MOVEMENT("Movement"), RENDER("Render")  , EXPLOIT("Exploit"), WORLD("World");

        public  String name;
        private  Category (String name){
            this.name = name;
        }
    }
}
