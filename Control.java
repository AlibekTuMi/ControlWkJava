import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Notebook1 {
    private String brand;
    private String color;
    private String screenResolution;
    private String processorModel;
    private int ramMemory;
    private int romMemory;
    private int videoMemory;

    public Notebook1(String brand, String color, String screenResolution, String processorModel, int ramMemory,
            int romMemory, int videoMemory) {
        this.brand = brand;
        this.color = color;
        this.screenResolution = screenResolution;
        this.processorModel = processorModel;
        this.ramMemory = ramMemory;
        this.romMemory = romMemory;
        this.videoMemory = videoMemory;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public int getRamMemory() {
        return ramMemory;
    }

    public int getRomMemory() {
        return romMemory;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public int getVideoMemory() {
        return videoMemory;
    }

    public void setProcessorModel(String processorModel) {
        this.processorModel = processorModel;
    }

    public void setRamMemory(int ramMemory) {
        this.ramMemory = ramMemory;
    }

    public void setRomMemory(int romMemory) {
        this.romMemory = romMemory;
    }

    public void setVideoMemory(int videoMemory) {
        this.videoMemory = videoMemory;
    }

    @Override
    public String toString() {

        return "Бренд: " + brand + "\n"
                + "Цвет: " + color + "\n"
                + "Разрешение экрана: " + screenResolution + "\n"
                + "Модель процессора: " + processorModel + "\n"
                + "Оперативная память (RAM): " + ramMemory + " GB" + "\n"
                + "Накопитель (Storage): " + romMemory + " GB" + "\n"
                + "Видеопамять (VideoMemory): " + videoMemory + " GB";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Notebook1 notebook = (Notebook1) obj;
        return brand.equals(notebook.brand) &&
                ramMemory == notebook.ramMemory &&
                romMemory == notebook.romMemory &&
                videoMemory == notebook.videoMemory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, screenResolution, processorModel, ramMemory, romMemory, videoMemory);
    }
}

public class Control {
    public static void main(String[] args) {
        Notebook1 notebook1 = new Notebook1("HP", "Красный", "720 x 960", "Intel", 8, 320, 4);
        Notebook1 notebook2 = new Notebook1("Lenovo", "Черный", "1920 x 1080", "Intel", 12, 480, 8);
        Notebook1 notebook3 = new Notebook1("Dell", "Черный", "1366 x 768", "AMD", 16, 480, 8);
        Notebook1 notebook4 = new Notebook1("Xiaomi", "Белый", "1920 x 1080", "Intel", 8, 320, 8);
        Notebook1 notebook5 = new Notebook1("Acer", "Белый", "1920 x 1080", "Intel", 16, 980, 12);
        Notebook1 notebook6 = new Notebook1("Asus", "Красный", "720 x 960", "AMD", 8, 480, 4);
        Notebook1 notebook7 = new Notebook1("Toshiba", "Черный", "1366 x 768", "AMD", 12, 320, 6);
        Notebook1 notebook8 = new Notebook1("Sony", "Стальной", "1366 x 768", "AMD", 12, 480, 8);
        Notebook1 notebook9 = new Notebook1("Acer", "Белый", "1920 x 1080", "Intel", 16, 980, 12);

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("По какому параметру будете производить поиск ноутбука?");
        System.out.println("Нажмите 1, чтобы искать по ОЗУ");
        System.out.println("Нажмите 2, чтобы искать по объёму ЖД");
        System.out.println("Нажмите 3, чтобы искать по видеопамяти");
        int choise = scanner.nextInt();
        
        int minRam = 0, minStorage = 0, minVideoMemory = 0;

        if (choise == 1) {
            System.out.print("Введите минимальный объем оперативной памяти (RAM) от 8 до 16: ");
            minRam = scanner.nextInt();
        } 
        else if (choise == 2) {
            System.out.print("Введите минимальный объем накопителя (Storage) от 320 до 980: ");
            minStorage = scanner.nextInt();
        } 
        else if (choise == 3) {
            System.out.print("Введите минимальный объем видеопамяти (Video Memory) от 4 до 12: ");
            minVideoMemory = scanner.nextInt();
        }

        scanner.close();

        HashSet<Notebook1> notebooks = new HashSet<>(
                Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5,
                        notebook6, notebook7, notebook8, notebook9));
        int count = 0;
        List<Notebook1> filteredLaptops = filterLaptops(notebooks, minRam, minStorage, minVideoMemory);
        System.out.println("\nРезультаты фильтрации:");
        for (Notebook1 laptop : filteredLaptops) {
            System.out.println(laptop);
            System.out.println("---------------------------------------");
            count++;

        }
        System.out.printf("Количество найденных ноутбуков: %d", count);
    }

    public static List<Notebook1> filterLaptops(HashSet<Notebook1> laptops, int minRam, int minStorage,
            int minVideoMemory) {
        List<Notebook1> filteredLaptops = new ArrayList<>();
        for (Notebook1 laptop : laptops) {
            if (minRam > 0) {
                if (laptop.getRamMemory() >= minRam) {
                    filteredLaptops.add(laptop);
                }
            }
            if (minStorage > 0) {
                if (laptop.getRomMemory() >= minStorage) {
                    filteredLaptops.add(laptop);
                }
            }
            if (minVideoMemory > 0) {
                if (laptop.getVideoMemory() >= minVideoMemory) {
                    filteredLaptops.add(laptop);
                }
            }

        }
        return filteredLaptops;
    }
}
