package com.personInfo.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/*
*   验证码生成
* */
public class VerifyCodeUtil {

        private final char[] code = {
                '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        /*
        *   字体
        * */
        private final String[] font = new String[]{
                "黑体","宋体","Courier","Arial",
                "Verdana", "Times", "Tahoma", "Georgia"
        };

        /*
        * 样式
        * */
        private final int[] style = new int[]{
                Font.BOLD,Font.ITALIC|Font.BOLD,Font.HANGING_BASELINE
        };
        /*
        *   验证码字符个数
        * */
        private int codeNumber = 4;

        /*
        *   图片字体大小
        * */
        public int size = 20;

        /*
        *   图片宽度
        * */
        public int width = 120;

        /*
        *   图片高度
        * */
        public int height = 45;//size+12;

        /*
        *   干扰线条数
        * */
        public int lines = 5;

        public void setSize(int size) {
            this.size = size;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setLines(int lines) {
            this.lines = lines;
        }

        public VerifyCodeUtil() {}


        /*
        *   指定验证码长度，图片宽度、高度
        * */
        public VerifyCodeUtil(int codeNumber, int width, int height){
            this.codeNumber = codeNumber;
            this.width = width;
            this.height = height;
        }

        /**
         * @Description 没有旋转的验证码图片
         * @Param  * @param String code
         * @return BufferedImage
         **/
        public BufferedImage getVerificationCode(String code){
             //  创建图片
            BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            g.setColor(new Color(246,240,250));
            //生成随机数
            Random ran = new Random();
            for (int i = 0; i < code.length(); i++) {
                //字体
                g.setFont(new Font(font[ran.nextInt(font.length)],style[ran.nextInt(style.length)],size));
                //生成随机颜色
                g.setColor(getRandomColor());
                //画验证码
                g.drawString(code.charAt(i)+"",i*size+10,size+5);
            }
            drawDisturbLine(g);
            //释放系统资源
            g.dispose();
            return image;
        }

        /**
         * @Description 生成带旋转的验证码图片
         * @Param  * @param String code
         * @return BufferedImage
         **/
        public BufferedImage rotatePicture(String code){
            //创建验证码图片
            BufferedImage rotateCodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = rotateCodeImage.createGraphics();
            //填充背景色
            g2d.setColor(new Color(246, 240, 250));
            g2d.fillRect(0, 0, width, height);
            //在图片上画验证码
            for(int i = 0;i < code.length();i++){
                BufferedImage rotateImage = getRotateImage(code.charAt(i));
                g2d.drawImage(rotateImage, null, (int) (this.height * 0.7) * i, 0);
            }
            drawDisturbLine(g2d);
            g2d.dispose();
            return rotateCodeImage;
        }

        /**
         * @Description 生成随机的验证码
         * @Param  * @param
         * @return String
         **/
        public String generatorVCode(){
            int len = code.length;
            Random ran = new Random();
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i < codeNumber;i++){
                int index = ran.nextInt(len);
                sb.append(code[index]);
            }
            return sb.toString();
        }

        /**
         * @Description 验证码画干扰线
         * @Param  * @param Graphics g
         * @return void
         **/
        private void drawDisturbLine(Graphics g){
            Random ran = new Random();
            for(int i = 0;i < lines;i++){
                int x1 = ran.nextInt(width);
                int y1 = ran.nextInt(height);
                int x2 = ran.nextInt(width);
                int y2 = ran.nextInt(height);
                g.setColor(getRandomColor());
                //画干扰线
                g.drawLine(x1, y1, x2, y2);
            }
        }

        /**
         * @Description 获取一张旋转的图片
         * @Param  * @param char c
         * @return BufferedImage
         **/
        private BufferedImage getRotateImage(char c){
            BufferedImage rotateImage = new BufferedImage(height, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rotateImage.createGraphics();
            //设置透明度为0
            g2d.setColor(new Color(255, 255, 255, 0));
            g2d.fillRect(0, 0, height, height);
            Random ran = new Random();
            g2d.setFont(new Font(font[ran.nextInt(font.length)], style[ran.nextInt(style.length)], size));
            g2d.setColor(getRandomColor());
            double theta = getTheta();
            //旋转图片
            g2d.rotate(theta, height/2, height/2);
            g2d.drawString(Character.toString(c), (height-size)/2, size+5);
            g2d.dispose();

            return rotateImage;
        }

        /**
         * @Description 随机返回一个颜色的
         * @Param  * @param
         * @return Color
         **/
        private Color getRandomColor(){
            Random ran = new Random();
            return new Color(ran.nextInt(220), ran.nextInt(220), ran.nextInt(220));
        }


        /**
         * @Description 验证码图片上的字符随机旋转一个角度
         * @Param  * @param
         * @return double
         **/
        private double getTheta(){
            return ((int) (Math.random()*1000) % 2 == 0 ? -1 : 1)*Math.random();
        }
}
