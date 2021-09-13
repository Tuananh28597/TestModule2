package com.codegym.cotroller;

import com.codegym.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.codegym.Main.scanner;

public class ContactManagement implements IGeneralManagement<Contact> {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getPhoneBooks() {
        return contacts;
    }

    public void setPhoneBooks(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public void showAll() {
        int count = 0;
        for (Contact contact : contacts) {
            System.out.println(contact);
            count++;
            if (count == 5) {
                count = 0;
                System.out.println(" Nhấn enter để hiển thị 5 mục tiếp theo: ");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void addNew(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void updateById(String phoneNumber, Contact phoneBook) {
        int index = findByPhoneNumber(phoneNumber);
        if (index != -1) {
            contacts.set(index, phoneBook);
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên !!!");
        }
    }

    @Override
    public void removeById(String phoneNumber) {
        int index = findByPhoneNumber(phoneNumber);
        if (index != -1) {
            System.out.println("Bạn có chắc chắn muốn xóa ?(Nhấn Y để xóa)");
            String choice1 = scanner.nextLine();
            switch (choice1) {
                case "y":
                case "Y": {
                    contacts.remove(index);
                    System.out.println("Đã xóa thành công");
                    break;
                }
                default: {
                    break;
                }
            }
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên !!!");
        }
    }

    @Override
    public int findByPhoneNumber(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void findContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(contact);
            } else {
                System.out.println("Không tìm thấy số điện thoại này !!!");
            }
        }
    }

    public void readContactFromFile() {
        try {
            FileReader fileReader = new FileReader("contact.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";

            while (true) {
                if (line == null) {
                    break;
                }
                line = bufferedReader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void writeContactToFile() {


        System.out.println("Bạn có chắc chắn muốn ghi?, nếu ghi chương trình sẽ cập nhật lại toàn bộ nội dung file.(Nhấn Y để ghi)");
        String choice1 = scanner.nextLine();
        switch (choice1) {
            case "y":
            case "Y": {
                try {
                    FileWriter fileWriter = new FileWriter("contact.csv");
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    for (Contact contact : contacts) {
                        bufferedWriter.write(String.valueOf(contact));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Ghi thành công !!!");
                System.out.println("Nhấn enter để tiếp tục :");
                scanner.nextLine();
                break;
            }
            default: {
                break;
            }
        }
    }


}
