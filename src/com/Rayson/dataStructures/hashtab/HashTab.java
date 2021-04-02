package com.Rayson.dataStructures.hashtab;

import java.util.Scanner;

public class HashTab {
    public static void main(String[] args) {
        EmpHashTab hashTab = new EmpHashTab(7);
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println(1 + "查询");
            System.out.println(2 + "添加");
            System.out.println(3 + "根据id查找");
            System.out.println(0 + "退出");
            switch (scanner.nextInt()) {
                case 1: {
                    hashTab.empList();
                    break;
                }
                case 2:{
                    System.out.println("输入id");
                    int id = new Scanner(System.in).nextInt();
                    System.out.println("输入name");
                    String name = new Scanner(System.in).nextLine();
                    Emp emp = new Emp(id, name);
                    hashTab.addEmp(emp);
                    break;
                }
                case 3:{
                    System.out.println("请输入id");
                    int id = new Scanner(System.in).nextInt();
                    hashTab.findEmpById(id);
                    break;
                }
                case 0:{
                    flag = false;
                    break;
                }
            }
        }
    }
}

class EmpHashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public EmpHashTab(int size) {
        this.size = size;
        this.empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加
    public void addEmp(Emp emp) {
        int no = hashFun(emp.getId());
        empLinkedLists[no].add(emp);
    }

    //遍历
    public void empList() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    //查找id
    public void findEmpById(int id){
        int no = hashFun(id);
        Emp emp = empLinkedLists[no].findById(id);
        if (emp != null){
            System.out.println(emp);
        }else {
            System.out.println("未找到");
        }
    }

    //编写散列表
    public int hashFun(int id) {
        return id % size;
    }
}

class EmpLinkedList {
    private Emp head = null;

    public Emp getHead() {
        return head;
    }

    public void setHead(Emp head) {
        this.head = head;
    }

    //添加
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        else {
            Emp cur = head;
            while (true) {
                if (cur.getNext() == null) {
                    break;
                }
                cur = cur.getNext();
            }
            cur.setNext(emp);
        }
    }

    //遍历
    public void list(int no) {
        if (head == null) {
            System.out.println(no + "链表空");
            return;
        }
        Emp cur = head;
        System.out.printf("第%d链表数据", no);
        System.out.println();
        while (true) {
            System.out.printf("id=%d，name=%s" ,cur.getId(), cur.getName());
            System.out.println();
            if (cur.getNext() == null) {
                return;
            }
            cur = cur.getNext();
        }
    }

    //根据id查找
    public Emp findById(int id) {
        if (head == null) {
            System.out.println("链表空");
            return null;
        }
        Emp cur = head;
        while (true) {
            if (cur.getId() == id) {
                return cur;
            }
            if (cur.getNext() == null) {
                break;
            }
            cur = cur.getNext();
        }
        return null;
    }
}

class Emp {
    private int id;
    private String name;
    private Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
