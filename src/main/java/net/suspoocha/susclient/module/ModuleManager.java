package net.suspoocha.susclient.module;

import net.suspoocha.susclient.module.movement.Flight;
import net.suspoocha.susclient.module.Mod.Category;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    private List<Mod> modules = new ArrayList<>();


    public ModuleManager() {
        addModules();
    }

    public List<Mod> getModules() {
        return modules;
    }

    public List<Mod> getEnabledModules() {
        List<Mod> enabled = new ArrayList<>();
        for (Mod module : modules) {
            if (module.isEnabled()) enabled.add(module);
        }
        return enabled;
    }
public List<Mod> getModulesInCategory(Category category){
        List<Mod>categoryModules = new ArrayList<>();
        for(Mod mod: modules  ){
            if(mod .getCategory()==category){
                categoryModules.add(mod);
            }
        }
        return  categoryModules;
}
    private void addModules() {
        modules.add(new Flight());
    }

}
