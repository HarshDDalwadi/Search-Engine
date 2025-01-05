package com.SearchApp;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.links[c - 'a'] == null)
                node.links[c - 'a'] = new TrieNode();
            node = node.links[c - 'a'];
        }
        node.flag = true;
    }

    public boolean searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.links[c - 'a'] == null) return false;
            node = node.links[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {
                "apple", "banana", "chair", "table", "orange", "cat", "dog", "mountain", "river", "lake",
                "coffee", "tea", "milk", "cheese", "bread", "cloud", "rain", "snow", "thunder", "lightning",
                "flower", "grass", "tree", "forest", "desert", "ocean", "beach", "sand", "stone", "rock",
                "car", "truck", "bicycle", "airplane", "train", "bus", "phone", "computer", "keyboard", "mouse",
                "monitor", "lamp", "sofa", "bed", "pillow", "blanket", "book", "notebook", "pen", "pencil",
                "eraser", "marker", "painter", "artist", "canvas", "brush", "museum", "castle", "palace", "village",
                "city", "country", "continent", "island", "bridge", "tower", "road", "path", "track", "field",
                "stadium", "gym", "classroom", "library", "school", "college", "university", "professor", "student", "teacher",
                "doctor", "nurse", "hospital", "clinic", "medicine", "syringe", "bandage", "ambulance", "firefighter", "police",
                "judge", "lawyer", "court", "prison", "garden", "park", "zoo", "aquarium", "animal", "bird",
                "fish", "reptile", "snake", "lion", "tiger", "elephant", "giraffe", "kangaroo", "koala", "panda",
                "penguin", "shark", "whale", "dolphin", "octopus", "crab", "lobster", "butterfly", "spider", "ant",
                "bee", "grasshopper", "cockroach", "mosquito", "dragonfly", "ladybug", "owl", "eagle", "hawk", "sparrow",
                "crow", "pigeon", "peacock", "parrot", "woodpecker", "penguin", "seal", "walrus", "polar", "iceberg",
                "volcano", "earthquake", "tsunami", "hurricane", "tornado", "cyclone", "cloudburst", "avalanche", "landslide", "blizzard",
                "sun", "moon", "star", "galaxy", "universe", "planet", "asteroid", "comet", "meteor", "satellite",
                "rocket", "spaceship", "astronaut", "alien", "robot", "machine", "factory", "industry", "technology", "software",
                "hardware", "network", "internet", "email", "password", "security", "firewall", "database", "server", "cloud",
                "storage", "backup", "algorithm", "program", "debug", "compile", "execute", "output", "input", "function",
                "variable", "constant", "array", "loop", "condition", "class", "object", "method", "inheritance", "polymorphism",
                "abstraction", "encapsulation", "exception", "thread", "process", "compiler", "interpreter", "syntax", "binary", "hexadecimal",
                "decimal", "integer", "float", "double", "boolean", "character", "string", "pointer", "reference", "stack"
        };

        for(String word : words)
            trie.insert(word);
    }
}
