import java.util.*;

class ThroneInheritance {

    private String king;
    private Map<String, List<String>> family;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();

        family.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        family.putIfAbsent(childName, new ArrayList<>());
        family.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String name, List<String> order) {
        // Add person if they are alive
        if (!dead.contains(name)) {
            order.add(name);
        }

        // Visit children in birth order
        for (String child : family.get(name)) {
            dfs(child, order);
        }
    }
}
