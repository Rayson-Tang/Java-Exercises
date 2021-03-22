package com.Rayson.dataStructures.linkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinked doubleLinked = new DoubleLinked();
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "吴用", "智多星");
        HeroNode2 heroNode3 = new HeroNode2(3, "卢俊义", "玉麒麟");
        HeroNode2 heroNode4 = new HeroNode2(4, "卢俊义1", "玉麒麟1");
        doubleLinked.add(heroNode1);
        doubleLinked.add(heroNode2);
        doubleLinked.add(heroNode3);
        doubleLinked.show();
        System.out.println("修改");
        doubleLinked.update(heroNode4);
        doubleLinked.show();
        System.out.println("删除");
        doubleLinked.delete(4);
        doubleLinked.show();
    }

    static class DoubleLinked {
        private HeroNode2 head = new HeroNode2(0, "", "");

        public HeroNode2 getHead() {
            return head;
        }

        //遍历双向链表
        public void show() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode2 temp = head.next;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }

        //添加节点
        public void add(HeroNode2 heroNode2) {
            HeroNode2 temp = head;
            boolean flag = true;
            while (temp.next != null) {
                if (temp.next.no == heroNode2.no) {
                    flag = false;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next = heroNode2;
                heroNode2.pre = temp;
            }
            else {
                System.out.println("该序号已存在，无法重复添加");
            }
        }

        //修改节点
        public void update(HeroNode2 heroNode2) {
            if (head.next == null) {
                System.out.println("数组为空");
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.no == heroNode2.no) {
                    flag = true;
                    break;
                }

                temp = temp.next;
            }
            if (flag) {
                temp.next.name = heroNode2.name;
                temp.next.nackName = heroNode2.nackName;
            }
            else {
                System.out.println("未找到该序号的节点");
            }
        }

        //删除节点
        public void delete(int no) {
            if (head.next == null) {
                System.out.println("队列空");
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.no == no) {
                    flag = true;
                    break;
                }

                temp = temp.next;
            }
            if (flag) {
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                temp.pre.next = temp.next;
            }
            else {
                System.out.println("未找到该节点");
            }
        }
    }

    static class HeroNode2 {
        private int no;
        private String name;
        private String nackName;
        private HeroNode2 next;
        private HeroNode2 pre;

        public HeroNode2(int no, String name, String nackName) {
            this.no = no;
            this.name = name;
            this.nackName = nackName;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNackName() {
            return nackName;
        }

        public void setNackName(String nackName) {
            this.nackName = nackName;
        }

        public HeroNode2 getNext() {
            return next;
        }

        public void setNext(HeroNode2 next) {
            this.next = next;
        }

        public HeroNode2 getPre() {
            return pre;
        }

        public void setPre(HeroNode2 pre) {
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "HeroNode2{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nackName='" + nackName + '\'' +
                    '}';
        }
    }

}
