package com.bob;

public class EaipMsg8917 {
    @Z03HeadCheck(dqdh="11")
    String dqdh;
    @Z03HeadCheck(jgdh="102")
    String jgdh;
    String jyrq;
    String jydm;


    public static void main(String[] args) {
        new EaipMsg8917();
    }
    public EaipMsg8917(){
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return "EaipMsg8917{" +
                "dqdh='" + dqdh + '\'' +
                ", jgdh='" + jgdh + '\'' +
                ", jyrq='" + jyrq + '\'' +
                ", jydm='" + jydm + '\'' +
                '}';
    }
}
