public class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;
    private boolean membershipIdSet;

    public LibraryMember() {
    }

    String getMembershipId() {
        return membershipId;
    }

    void setMembershipId(String id) {
        if (!membershipIdSet) {
            this.membershipId = id;
            this.membershipIdSet = true;
        }
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    boolean isPremiumMember() {
        return premiumMember;
    }

    void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    void setSecurityAnswer(String answer) {
        this.securityAnswerHash = String.valueOf(answer.hashCode());
    }

    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId());

        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());

        System.out.println(m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
    }
}
