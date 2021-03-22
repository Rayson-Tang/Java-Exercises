package com.Rayson.dataStructures.linkedList;

public class SingleLinkedList {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2,"吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3,"卢俊义", "玉麒麟");
        HeroNode heroNode4 = new HeroNode(4,"卢俊义1", "玉麒麟1");
        SingleLinked singleLinked = new SingleLinked();
//        singleLinked.add(heroNode1);
//        singleLinked.add(heroNode2);
//        singleLinked.add(heroNode3);
        singleLinked.addByOrder(heroNode1);
        singleLinked.addByOrder(heroNode3);
        singleLinked.addByOrder(heroNode2);
        singleLinked.show();
        System.out.println("反转");
        reverse(singleLinked.getHead());
        singleLinked.show();
//        System.out.println("倒数");
//        HeroNode index = findIndex(singleLinked.getHead(), 4);
//        System.out.println(index);
//        int i = realNum(singleLinked.getHead());
//        System.out.println(i);
//        singleLinked.update(heroNode4);
//        singleLinked.delete(3);
//        singleLinked.delete(2);
//        singleLinked.delete(1);
//        delIndex(singleLinked.getHead(), 3);
//        System.out.println("修改后");
//        singleLinked.show();
    }

    //反转链表
    public static void reverse(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode head2 = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = next;
        }
        head.next = head2.next;

    }

    //获取有效个数
    public static int realNum(HeroNode head){
        int length = 0;
        if (head.next == null){
            System.out.println("链表空");
            return 0;
        }
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //删除倒数数据
    public static void delIndex(HeroNode head, int index){
        SingleLinked singleLinked = new SingleLinked();
        int length = realNum(head);
        HeroNode cur = head.next;
        int num = 1;
        if (index > length){
            System.out.println("超过长度");
            return;
        }
        if (index == length){
            head.next = cur.next;

            return;
        }

        while (true){
            if (num == length - index){
                cur.next = cur.next.next;
                break;
            }
            num++;
            cur = cur.next;
        }
    }

    //查找倒数节点
    public static HeroNode findIndex(HeroNode head, int index){
        if (head.next == null){
            System.out.println("没有找到");
            return null;
        }
        int size = realNum(head);
        if (index > size || index <= 0){
            System.out.println("非法输入");
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    //管理链表
    static class SingleLinked{
        private HeroNode head = new HeroNode(0,"","");

        public HeroNode getHead(){
            return head;
        }

        //添加元素
        public void add(HeroNode heroNode){
            HeroNode temp = head;
            while (true){
                if (temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = heroNode;
        }

        //顺序添加
        public void addByOrder(HeroNode heroNode){
            HeroNode temp = head;
            boolean flag = false;
            while (true){
                if (temp.next==null){
                    break;
                }
                if (temp.next.no>heroNode.no){
                    break;
                }else if (temp.next.no == heroNode.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag){
                System.out.println("不能添加");
            }
            else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        //修改元素
        public void update(HeroNode heroNode){
            HeroNode temp = head;
            boolean flag = false;
            while (true){
                if (temp.next == null){
                    flag = true;
                    break;
                }
                if (temp.next.no == heroNode.no){
                    break;
                }
                temp = temp.next;
            }
            if (flag){
                System.out.println("未找到该数据");
            }
            else {
                temp.next.name = heroNode.name;
                temp.next.nackName = heroNode.nackName;
            }
        }

        //删除节点
        public void delete(int no){
            HeroNode temp = head;
            boolean flag = false;
            while (true){
                if (temp.next == null){
                    flag = true;
                    break;
                }
                if (temp.next.no == no){
                    break;
                }
                temp = temp.next;
            }
            if (flag){
                System.out.println("未找到该节点");
            }
            else {
                temp.next = temp.next.next;
            }
        }



        //遍历链表
        public void show(){
            if (head.next == null){
                System.out.println("链表空");
                return;
            }
            HeroNode temp = head.next;
            while (true){
                System.out.println(temp);
                if (temp.next == null){
                    break;
                }
                temp = temp.next;
            }

        }
    }

    static class HeroNode{
        public int no;
        public String name;
        public String nackName;
        public HeroNode next;
        public HeroNode(int no,String name, String nackName){
            this.no = no;
            this.nackName = nackName;
            this.name = name;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nackName='" + nackName + '\'' +
                    '}';
        }
    }
}
