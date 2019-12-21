package com.example.gauth_sys;

public class Employee {
    public long id;
    public long empl_id;
    public String empl_name;
    public String empl_contact;
    public int empl_guests_no;
    public String empl_entry_check;

    public Employee() {

    }

    public Employee(long id,long empl_id,String empl_name,String empl_contact,int empl_guests_no,String empl_entry_check){
        this.id = id;
        this.empl_id = empl_id;
        this.empl_name = empl_name;
        this.empl_contact = empl_contact;
        this.empl_guests_no = empl_guests_no;
        this.empl_entry_check = empl_entry_check;
    }
}
