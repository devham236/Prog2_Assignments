package assignment_05.treasure;

public enum Island implements State {
    SHIPWRECK_BAY("Shipwreck Bay"){
        @Override
        public State transition(Action action){
            return switch (action){
                case A -> MUSKET_HILL;
                case B -> DEAD_MANS_ISLAND;
            };
        }
    },

    DEAD_MANS_ISLAND("Dead Man's Island"){
        @Override
        public State transition(Action action){
            return switch (action){
                case A -> MUSKET_HILL;
                case B -> SHIPWRECK_BAY;
            };
        }
    },

    TREASURE_ISLAND("Treasure Island"){
        @Override
        public State transition(Action action){
            return switch (action){
                case A -> TREASURE_ISLAND;
                case B -> TREASURE_ISLAND;
            };
        }
    },

    PIRATES_ISLAND("Pirates Island"){
        @Override
        public State transition(Action action){
            return switch (action){
                case A -> SHIPWRECK_BAY;
                case B -> MUSKET_HILL;
            };
        }
    },

    MUTINEERS_ISLAND("Mutineers Island"){
        @Override
        public State transition(Action action){
            return switch (action){
                case A -> SMUGGLERS_COVE;
                case B -> DEAD_MANS_ISLAND;
            };
        }
    },

    SMUGGLERS_COVE("Smugglers Cove"){
        @Override
        public State transition(Action action){
            return switch (action){
                case A -> PIRATES_ISLAND;
                case B -> TREASURE_ISLAND;
            };
        }
    },

    MUSKET_HILL("Musket Hill"){
        @Override
        public State transition(Action action){
            return switch (action){
                case A -> PIRATES_ISLAND;
                case B -> MUTINEERS_ISLAND;
            };
        }
    };

    private final String name;

    Island(String name){
        this.name = name;
    }

    @Override
    public String str(){
        return this.name;
    }

    @Override
    public String info(){
        return "Zustand: " + this.name + "\n" +
                "Aktion A -> " + transition(Action.A).str() + "\n" +
                "Aktion B -> " + transition(Action.B).str();
    }

}
