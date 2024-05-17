import company.models.Manager;
import company.models.Worker;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Aleksandra Wójcik", 5300, 1);
        Worker worker2 = new Worker("Adam Nowak", 4200, 2);
        Worker worker3 = new Worker("Kamil Kowalski", 3200, 3);
        Worker worker4 = new Worker("Oliwia Roza", 5100, 4);
        Manager manager = new Manager("Kuba Wilk", 2700, 5);

        Worker[] workers = {worker1, worker2, worker3, worker4};
        for (Worker worker : workers) {
            System.out.println("Wynagrodzenie " + worker.getName() + ": " + worker.getSalary());
            worker.work();
        }

        System.out.println("Wynagrodzenie " + manager.getName() + ": " + manager.getSalary());
        manager.work();
    }
}