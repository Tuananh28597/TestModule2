package com.codegym.view;

import com.codegym.cotroller.ContactManagement;
import com.codegym.model.Contact;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codegym.Main.scanner;

public class ContactMenu {
    public static ContactManagement contactManagement = new ContactManagement();

    public void run(){
        int choice;

        do {
            Contact contact = new Contact();

            menu();
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{
                    showAllPhoneBook();
                    break;
                }
                case 2:{
                    addNewContact();
                    break;
                }
                case 3:{
                    updateContact();
                    break;
                }
                case 4:{
                    deleteContact();
                    break;
                }
                case 5:{
                    findByPhoneNumber();
                    break;
                }
                case 6:{
                    readFromFile();
                    break;
                }
                case 7:{
                    writeToFile();
                    break;
                }
                case 8:
            }
        }while(choice!=0);

    }

    private void writeToFile() {
        contactManagement.writeContactToFile();
    }

    private void readFromFile() {
        contactManagement.readContactFromFile();
    }

    private void findByPhoneNumber() {
        System.out.println("Nhập số điện thoại cần tìm thông tin: ");
        String phoneNumber = scanner.nextLine();
        contactManagement.findContactByPhoneNumber(phoneNumber);

    }

    private void deleteContact() {
        System.out.println("Nhập vào số điện thoại muốn xóa");
        String phoneNumber = scanner.nextLine();
        contactManagement.removeById(phoneNumber);
    }

    private void updateContact() {
        System.out.println("Nhập vào số điện thoại cần cập nhật thông tin: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = inputNewContact();
        contactManagement.updateById(phoneNumber,contact);
    }

    private void addNewContact() {
        Contact contact = inputNewContact();
        contactManagement.addNew(contact);

    }

    private Contact inputNewContact() {
        System.out.println("Thêm danh bạ mới: ");
        System.out.println("Nhập số điện thoại: ");
        Matcher matcher;
        String phoneNumber;
        do {
            System.out.println("Nhập số điện thoại");
            phoneNumber = scanner.nextLine();
            String regex = "^[0-9]{2}-0[1-9][0-9]{8}$";
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(phoneNumber);
            if (!matcher.matches()) {
                System.err.println("Sai mã vùng hoặc số điện thoại");
            }
        } while (!matcher.matches());
        System.out.println("Nhập nhóm danh bạ: ");
        String group = scanner.nextLine();
        System.out.println("Nhập tên danh bạ: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String birthDay = scanner.nextLine();
        System.out.println("Nhập email: ");
        Matcher matcher1;
        String email;
        do {
            email = scanner.nextLine();
            String regex = "^[A-Za-z0-9_]{4,}@[A-Za-z]mail.com$";
            Pattern pattern = Pattern.compile(regex);
            matcher1 = pattern.matcher(email);
            if (!matcher1.matches()) {
                System.err.println("Mail không hợp lệ");
            }
        } while (!matcher1.matches());
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        Contact contact = new Contact(phoneNumber,group,name,sex,birthDay,email,address);
        return contact;
    }

    private void showAllPhoneBook() {
        contactManagement.showAll();
    }

    private void menu() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọnn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Đóng chương trình ");
    }
}
