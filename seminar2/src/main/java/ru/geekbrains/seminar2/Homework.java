package ru.geekbrains.seminar2;

//TODO: домашняя работа
// 1.  Доработать метод generateEmploeyee(), вернуть сотрудника определенного типа.
// 2***. Метод generateEmploeyee() должен быть без входных параметров, тип сотрудника,
// фио и ставка генерируются автоматически.

public class Homework {

    static Employee generateEmploeyee(){

        String[] names = new String[] { "Sigizmund ", "Kairat ", "Oljas ", "Sergazy ", "Kanat ", "Kenes " };
        String[] surnames = new String[] { "Ivanov ", "Petrov ", "Syleimenov ", "Malkin ", "Palkin ", "Zalkind " };
        String [] id = new String[] {"Worker", " Freelanser"};
        int [] salary = new int[] {30000,50000,70000};

        int n1 = (int)Math.floor(Math.random() * names.length);
        int n2 = (int)Math.floor(Math.random() * surnames.length);
        int n3 = (int)Math.floor(Math.random() * id.length);
        int n4 = (int)Math.floor(Math.random() * salary.length);

        if (id[n3] == "Worker") {
            System.out.println(names[n1] + surnames[n2] + id[n3] + " Fixed rate: " + salary[n4] + "(rub)");
        }
        else {
            System.out.println(names[n1] + surnames[n2] + id[n3] + " Average monthly salary: " + (salary[n4]*1.3)   + " Fixed rate " + salary[n4] + "(rub)");
        }
        //TODO:  Доработать самостоятельно.
        return  null;
    }


    public static void main(String[] args) {

        Worker worker1 = new Worker("Tony", "Blar", 70000);
        Freelancer freelance1 = new Freelancer("Jony", "Gramm", 70000);

        Employee[] employees = new Employee[10]; // Создали массив Employee на 10 персон
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmploeyee();
        }
        for (Employee employee : employees) {

        }
    }
}

// Создали базовый класс работника
abstract class Employee {
    protected String name;
    protected String surname;
    protected double salary;


    public String getName() {
        return name;
    } // ����������

    public void setName(String name) {
        this.name = name;
    } // ��� ������

    public String getSurname() {
        return surname;
    } // ����������

    public void setSurname(String surname) {
        this.surname = surname;
    } // ��� ������

    public double getSalary() {
        return salary;
    } // ����������

    public void setSalary(double salary) {
        this.salary = salary;
    } // ��� ������

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    /**
     * расчет среднемесячной заработной платы * @return
     */
    public abstract double calculateSalary();

}

class Freelancer extends Employee{
    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }
    @Override
    public double calculateSalary() {
        return 15 * 6 * salary / 22 / 8;
    }
    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.); фиксированная ставка: %.2f (руб.)",
                surname, name, calculateSalary(), salary);
    }
}

class Worker extends Employee{

    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }
    @Override
    public double calculateSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная ставка): %.2f (руб.)",
                surname, name, salary);
    }
}