package com.Rayson.algorithm.huffmanCode;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String str = "ilike";
        byte[] bytes = str.getBytes();
        byte[] bytes1 = huffmanZip(bytes);
        System.out.println(Arrays.toString(bytes1));
        byte[] decode = decode(huffmanCodes, bytes1);
        System.out.println(new String(decode));
    }

    //压缩文件
    //srcFile压缩文件路径
    //dsFile压缩后位置
    private static void zipFile(String srcFile, String dsFile) {
        //创建输入流
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);

            //创建和源文件一样大的byte数组
            byte[] bytes = new byte[is.available()];
            //读取文件
            is.read(bytes);
            //获取对应赫夫曼编码表
            byte[] huffmanZip = huffmanZip(bytes);
            //创建输出流
            os = new FileOutputStream(dsFile);
            //创建一个和文件输出流相连的
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanZip);
            oos.writeObject(huffmanCodes);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                is.close();
                oos.close();
                os.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //解压文件
    private static void unZipFile(String zipFile, String dstFile){
        FileInputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        try{
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[])ois.readObject();
            Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();
            byte[] decode = decode(huffmanCodes, huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(decode);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                ois.close();
                os.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //解压

    private static byte[] decode(Map<Byte, String> map, byte[] huffmanBytes) {
        //得到二进制字符串
        StringBuilder stringBuilder1 = new StringBuilder();
        //将byte转为二进制
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder1.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        Map<String, Byte> map1 = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map1.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<Byte>();
        for (int i = 0; i < stringBuilder1.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = stringBuilder1.substring(i, i + count);
                b = map1.get(key);
                if (b == null) {
                    count++;
                }
                else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            b[i] = list.get(i);
        }
        return b;

    }

    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String string = Integer.toBinaryString(temp);
        if (flag) {
            return string.substring(string.length() - 8);
        }
        else {
            return string;
        }
    }

    //压缩
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //创建赫夫曼树
        Node huffman = createHuffman(nodes);
        //生成赫夫曼编码
        Map<Byte, String> codes = getCodes(huffman);
        byte[] zip = zip(bytes, codes);
        return zip;

    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder1 = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder1.append(huffmanCodes.get(b));
        }
        int len;
        if (stringBuilder1.length() / 8 == 0) {
            len = stringBuilder1.length() / 8;
        }
        else {
            len = stringBuilder1.length() / 8 + 1;
        }
        int index = 0;
        byte[] huffmanByte = new byte[len];
        for (int i = 0; i < stringBuilder1.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder1.length()) {
                strByte = stringBuilder1.substring(i);
            }
            else {
                strByte = stringBuilder1.substring(i, i + 8);
            }
            huffmanByte[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanByte;
    }

    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    static StringBuilder stringBuilder = new StringBuilder();

    //重载
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root, "0", stringBuilder);
        getCodes(root, "1", stringBuilder);
        return huffmanCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.date == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            }
            else {
                huffmanCodes.put(node.date, stringBuilder2.toString());

            }
        }
    }

    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
        for (Byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            }
            else {
                map.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //创建赫夫曼树
    private static Node createHuffman(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //移除已处理
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //加入新的
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //前序遍历
    private static void preOrder(Node root) {
        if (root == null) {
            System.out.println("空");
        }
        else {
            root.preOrder();
        }
    }
}


class Node implements Comparable<Node> {
    Byte date;//'a'->97
    int weight;//权重，出现次数
    Node left;
    Node right;

    public Node(Byte date, int weight) {
        this.date = date;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;//从小到大排序
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
