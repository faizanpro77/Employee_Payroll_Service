package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }
    private List<EmployeePayrollData> employeePayrollDataList;
    public EmployeePayrollService(){}

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollDataList) {
        this.employeePayrollDataList = employeePayrollDataList;
    }

    private void readEmployeePayrollData(Scanner consoleInputReader){
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        consoleInputReader.nextLine();
        System.out.println("Enter employee Name: ");
        String name = consoleInputReader.nextLine();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollDataList.add(new EmployeePayrollData(id, name, salary));
    }

    private void writeEmployeePayrollData(){
        System.out.println("Writing employee payroll to console\n" + employeePayrollDataList);
    }

    public void writeEmployeeData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("Writing Employee Payroll Roster in Console\n" + employeePayrollDataList);
        else if (ioService.equals(IOService.FILE_IO)) {
            EmployeePayrollFileIOService.writeData(employeePayrollDataList);
        }
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            return employeePayrollDataList.size();
        else if (ioService.equals(IOService.FILE_IO))
            return EmployeePayrollFileIOService.countEntries();
        return 0;
    }

    public void printData(IOService ioService){
        if (ioService.equals(IOService.FILE_IO)){
            new EmployeePayrollFileIOService().printDataFromFile();
        }
    }

    public void readDataFromFile(IOService ioService){
        if(ioService.equals(IOService.CONSOLE_IO)){
            new EmployeePayrollFileIOService().readDataFromFile();
        }
    }

    public static void main(String[] args) {
        System.out.println("welcome to employee payroll service");
        ArrayList<EmployeePayrollData> employeePayrollDataList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollDataList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }
}

