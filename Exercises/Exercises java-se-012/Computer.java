public class Computer {

   
    private final String brand;
    private final String model;
    private final double price;

    
    public Computer(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    
    public static class Processor {
        private final String type;
        private final double speed;
        private final int cores;

        public Processor(String type, double speed, int cores) {
            this.type = type;
            this.speed = speed;
            this.cores = cores;
        }

        @Override
        public String toString() {
            return "Processor Type: " + type +
                   ", Speed: " + speed + "GHz" +
                   ", Cores: " + cores;
        }
    }

    public class Memory {
        private final int ram;      
        private final int storage;  

        public Memory(int ram, int storage) {
            this.ram = ram;
            this.storage = storage;
        }

        @Override
        public String toString() {
            return "RAM: " + ram + "GB, Storage: " + storage + "GB";
        }
    }

   
    public void displayDetails(Processor processor, Memory memory) {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: KSh " + price);
        System.out.println(processor);
        System.out.println(memory);
    }

  
    public static void main(String[] args) {

      
        Computer laptop1 = new Computer("HP", "Pavilion", 85000);
        Computer.Processor cpu1 = new Computer.Processor("Intel Core i5", 2.5, 4);
        Computer.Memory mem1 = laptop1.new Memory(8, 512);

        laptop1.displayDetails(cpu1, mem1);

       

       
        Computer laptop2 = new Computer("Dell", "Inspiron", 120000);
        Computer.Processor cpu2 = new Computer.Processor("Intel Core i7", 3.2, 8);
        Computer.Memory mem2 = laptop2.new Memory(16, 1024);

        laptop2.displayDetails(cpu2, mem2);
    }
}
