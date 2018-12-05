package demo1;

public class Hero {
    String name;
    String createplace;
    String sex;
    int createtime;
    int deathtime;
    int level;

    public Hero(String name, String createplace, String sex, int createtime, int deathtime, int level) {
        this.name = name;
        this.createplace = createplace;
        this.sex = sex;
        this.createtime = createtime;
        this.deathtime = deathtime;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateplace() {
        return createplace;
    }

    public void setCreateplace(String createplace) {
        this.createplace = createplace;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
    }

    public int getDeathtime() {
        return deathtime;
    }

    public void setDeathtime(int deathtime) {
        this.deathtime = deathtime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", createplace='" + createplace + '\'' +
                ", sex='" + sex + '\'' +
                ", createtime=" + createtime +
                ", deathtime=" + deathtime +
                ", level=" + level +
                '}';
    }
    public int getage(){
        return this.getDeathtime ()-getCreatetime ();
    }
    public String getagelevel(){
        if (this.getage ()>=0&&this.getage ()<=20){
            return "0~20";
        }else if (this.getage ()>=21&&this.getage ()<=40){
            return "21~40";
        }else if (this.getage ()>=41&&this.getage ()<=60){
            return "41~60";
        }else {
            return "60以上";
        }
    }
    public String getlevelsection(){
        if (this.getLevel ()>=90){
            return ">=90";
        }else if (this.getLevel ()>=80&&this.getLevel ()<=89){
            return "80~89";
        }else if (this.getLevel ()>=70&&this.getLevel ()<=79){
            return "70~79";
        }else {
            return "<70";
        }
    }
}
