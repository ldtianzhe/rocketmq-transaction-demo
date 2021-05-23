package com.xxx.common.utils;

import java.math.BigDecimal;
import java.util.Random;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2020-03-12
 * @Version 1.0
 **/
public class RandomValueUtils {

    public static String BASE = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static String FIRSTNAME = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘" +
            "葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵" +
            "湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞" +
            "万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫" +
            "乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠" +
            "蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古" +
            "易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查" +
            "后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐" +
            "钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百" +
            "里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";

    private static String GIRL = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳" +
            "嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜" +
            "纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";

    public static String BOY = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子" +
            "杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏" +
            "言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

    public static final String[] EMAIL_SUFFIX = ("@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com" +
            ",@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com" +
            ",@126.com,@sina.com,@sohu.com,@yahoo.com.cn").split(",");

    private static String[] TELFIRST="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");


    /**
     * 随机生成min-max之间的金额
     * @return
     */
    public static BigDecimal randomPrice(){
        int max = 10000;
        int min = 1;
        Random random = new Random();
        return new BigDecimal(Double.toString(random.nextInt(max)%(max-min+1) + min));
    }
    /**
     * 随机生成年龄
     * @return
     */
    public static int randomAge(){
        int max = 100;
        int min = 18;
        Random random = new Random();
        return random.nextInt(max)%(max-min+1) + min;
    }
    /**
     * 随机获取元素（订单状态和支付状态）
     * @return
     */
    public static int randomTest1(){
        int[] doc = {1, 2, 3, 4,5};
        int index = (int) (Math.random() * doc.length);
        return doc[index];
    }

    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    /**
     * 随机生成email
     * @param lMin
     * @param lMax
     * @return
     */
    public static String getEmail(int lMin,int lMax) {
        int length=getNum(lMin,lMax);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int)(Math.random()*BASE.length());
            sb.append(BASE.charAt(number));
        }
        sb.append(EMAIL_SUFFIX[(int)(Math.random()*EMAIL_SUFFIX.length)]);
        return sb.toString();
    }

    /**
     * 随机生成11位手机号码
     * @return
     */
    public static String getTelephone() {
        int index=getNum(0,TELFIRST.length-1);
        String first= TELFIRST[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+thrid;
    }

    /**
     * 随机生成中文名
     * @return
     */
    public static String getChineseName() {
        String name_sex = "";
        int index = getNum(0, FIRSTNAME.length() - 1);
        String first = FIRSTNAME.substring(index, index + 1);
        int sex = getNum(0, 1);
        String str = BOY;
        int length = BOY.length();
        if (sex == 0) {
            str = GIRL;
            length = GIRL.length();
            name_sex = "女";
        } else {
            name_sex = "男";
        }
        index = getNum(0, length - 1);
        String second = str.substring(index, index + 1);
        int hasThird = getNum(0, 1);
        String third = "";
        if (hasThird == 1) {
            index = getNum(0, length - 1);
            third = str.substring(index, index + 1);
        }
        return first + second + third;
    }

}
