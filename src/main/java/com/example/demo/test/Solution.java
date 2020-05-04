package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

/**
 * 设定初始位置和给定每个粒子质量和随机速度，
 * 然后计算力和运动方程，
 * 再根据所有原子的速度计算出系统温度。
 * 由此循环一段时间也就可以输出  温度-时间曲线。
 * 然后再调整其中的参数
 */
public class Solution {
    private List<Particle> coorList;
    private List<Double> place;
    private double[] xyzplace = new double[1000];
    private double[] lastplace = new double[1000];

    private int len;
    private List<Double> iFList;
    private List<Double> iTem;
    private double a = 3.405e-10;
    private double b = 0.492;
    private double c = 6.63e-26;
    private double t = 1e-15;
    private double kb = 1.38e-23;



    //设定初始位置,len-边长（m）,初始速度在参与计算时随机生成
    public void initCoordinate(){
        double a, b, c;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 100; j++){
                    a = i / 10 * len;
                    b = j / 10 * len;
                    c = k / 100 * len;

                    coorList.add(new Particle(a, b, c));

                }
            }
        }
    }

    //计算力和运动方程
    public void calF(){
        double tmp = 0;
        double r = 0;
        double fi = 0;

        for(int i = 0; i < 1000; i++){
            for(int j = i + 1; j < 1000; j++){

                 tmp = pow(coorList.get(i).getX() - coorList.get(j).getX(), 2)
                        + pow(coorList.get(i).getY() - coorList.get(j).getY(), 2)
                        + pow(coorList.get(i).getY() - coorList.get(j).getY(), 2);
                 r = pow(tmp, 0.5);
                 place.add(r);
                if(tmp < 0.3){
                    fi = -48*b*pow(1/r,13)*pow(a,12)+24*b*pow(a,6)*pow(1/r,7);
                }

            }
            iFList.add(fi);
        }

    }

    //计算温度
    public void calTem(){
        double x = 0;
        double xx = 0;//下一步的位置
        double xm = 0;//当前位置
        double xm2 = 0;//上一步的位置
        double vi = 0;
        double t2 = 0;
        double v2 = 0;

        for(int time = 0; time < 1000; t+=1e-15){
            for(int i = 0; i < 1000; i++){
                if(time == 0){
                    xm2 = 0;
                    xm = place.get(i);
                }if(time == 1){
                    xm2 = random();
                    xm = xyzplace[i];
                }else{
                    xm2 = lastplace[i];
                    xm = xyzplace[i];
                }

                lastplace[i] = xm;
                xx = 2 * xm - xm2 + iFList.get(i)/c*pow(t, 2);
                xyzplace[i] = xx;
                vi = (xx - xm2)/(2 * t);
                v2 += pow(vi, 2);


            }
            iTem.add(v2*c/((3*1000 - 3)*kb));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.len = 1;
        solution.coorList = new ArrayList<>();
        solution.iFList = new ArrayList<>();
        solution.iTem = new ArrayList<>();
        solution.place = new ArrayList<>();

        solution.initCoordinate();
        solution.calF();
        solution.calTem();
        System.out.println(solution.iTem);

    }
    
}
