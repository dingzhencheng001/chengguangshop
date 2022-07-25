package my.fast.admin.cg.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysDicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDicExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDicdefineIsNull() {
            addCriterion("DICDEFINE is null");
            return (Criteria) this;
        }

        public Criteria andDicdefineIsNotNull() {
            addCriterion("DICDEFINE is not null");
            return (Criteria) this;
        }

        public Criteria andDicdefineEqualTo(String value) {
            addCriterion("DICDEFINE =", value, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineNotEqualTo(String value) {
            addCriterion("DICDEFINE <>", value, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineGreaterThan(String value) {
            addCriterion("DICDEFINE >", value, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineGreaterThanOrEqualTo(String value) {
            addCriterion("DICDEFINE >=", value, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineLessThan(String value) {
            addCriterion("DICDEFINE <", value, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineLessThanOrEqualTo(String value) {
            addCriterion("DICDEFINE <=", value, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineLike(String value) {
            addCriterion("DICDEFINE like", value, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineNotLike(String value) {
            addCriterion("DICDEFINE not like", value, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineIn(List<String> values) {
            addCriterion("DICDEFINE in", values, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineNotIn(List<String> values) {
            addCriterion("DICDEFINE not in", values, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineBetween(String value1, String value2) {
            addCriterion("DICDEFINE between", value1, value2, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdefineNotBetween(String value1, String value2) {
            addCriterion("DICDEFINE not between", value1, value2, "dicdefine");
            return (Criteria) this;
        }

        public Criteria andDicdescIsNull() {
            addCriterion("DICDESC is null");
            return (Criteria) this;
        }

        public Criteria andDicdescIsNotNull() {
            addCriterion("DICDESC is not null");
            return (Criteria) this;
        }

        public Criteria andDicdescEqualTo(String value) {
            addCriterion("DICDESC =", value, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescNotEqualTo(String value) {
            addCriterion("DICDESC <>", value, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescGreaterThan(String value) {
            addCriterion("DICDESC >", value, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescGreaterThanOrEqualTo(String value) {
            addCriterion("DICDESC >=", value, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescLessThan(String value) {
            addCriterion("DICDESC <", value, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescLessThanOrEqualTo(String value) {
            addCriterion("DICDESC <=", value, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescLike(String value) {
            addCriterion("DICDESC like", value, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescNotLike(String value) {
            addCriterion("DICDESC not like", value, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescIn(List<String> values) {
            addCriterion("DICDESC in", values, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescNotIn(List<String> values) {
            addCriterion("DICDESC not in", values, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescBetween(String value1, String value2) {
            addCriterion("DICDESC between", value1, value2, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDicdescNotBetween(String value1, String value2) {
            addCriterion("DICDESC not between", value1, value2, "dicdesc");
            return (Criteria) this;
        }

        public Criteria andDiccodeIsNull() {
            addCriterion("DICCODE is null");
            return (Criteria) this;
        }

        public Criteria andDiccodeIsNotNull() {
            addCriterion("DICCODE is not null");
            return (Criteria) this;
        }

        public Criteria andDiccodeEqualTo(String value) {
            addCriterion("DICCODE =", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeNotEqualTo(String value) {
            addCriterion("DICCODE <>", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeGreaterThan(String value) {
            addCriterion("DICCODE >", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeGreaterThanOrEqualTo(String value) {
            addCriterion("DICCODE >=", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeLessThan(String value) {
            addCriterion("DICCODE <", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeLessThanOrEqualTo(String value) {
            addCriterion("DICCODE <=", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeLike(String value) {
            addCriterion("DICCODE like", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeNotLike(String value) {
            addCriterion("DICCODE not like", value, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeIn(List<String> values) {
            addCriterion("DICCODE in", values, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeNotIn(List<String> values) {
            addCriterion("DICCODE not in", values, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeBetween(String value1, String value2) {
            addCriterion("DICCODE between", value1, value2, "diccode");
            return (Criteria) this;
        }

        public Criteria andDiccodeNotBetween(String value1, String value2) {
            addCriterion("DICCODE not between", value1, value2, "diccode");
            return (Criteria) this;
        }

        public Criteria andDicnameIsNull() {
            addCriterion("DICNAME is null");
            return (Criteria) this;
        }

        public Criteria andDicnameIsNotNull() {
            addCriterion("DICNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDicnameEqualTo(String value) {
            addCriterion("DICNAME =", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameNotEqualTo(String value) {
            addCriterion("DICNAME <>", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameGreaterThan(String value) {
            addCriterion("DICNAME >", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameGreaterThanOrEqualTo(String value) {
            addCriterion("DICNAME >=", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameLessThan(String value) {
            addCriterion("DICNAME <", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameLessThanOrEqualTo(String value) {
            addCriterion("DICNAME <=", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameLike(String value) {
            addCriterion("DICNAME like", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameNotLike(String value) {
            addCriterion("DICNAME not like", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameIn(List<String> values) {
            addCriterion("DICNAME in", values, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameNotIn(List<String> values) {
            addCriterion("DICNAME not in", values, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameBetween(String value1, String value2) {
            addCriterion("DICNAME between", value1, value2, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameNotBetween(String value1, String value2) {
            addCriterion("DICNAME not between", value1, value2, "dicname");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNull() {
            addCriterion("ISUSE is null");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNotNull() {
            addCriterion("ISUSE is not null");
            return (Criteria) this;
        }

        public Criteria andIsuseEqualTo(String value) {
            addCriterion("ISUSE =", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotEqualTo(String value) {
            addCriterion("ISUSE <>", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThan(String value) {
            addCriterion("ISUSE >", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThanOrEqualTo(String value) {
            addCriterion("ISUSE >=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThan(String value) {
            addCriterion("ISUSE <", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThanOrEqualTo(String value) {
            addCriterion("ISUSE <=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLike(String value) {
            addCriterion("ISUSE like", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotLike(String value) {
            addCriterion("ISUSE not like", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseIn(List<String> values) {
            addCriterion("ISUSE in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotIn(List<String> values) {
            addCriterion("ISUSE not in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseBetween(String value1, String value2) {
            addCriterion("ISUSE between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotBetween(String value1, String value2) {
            addCriterion("ISUSE not between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andCrtUserIsNull() {
            addCriterion("CRT_USER is null");
            return (Criteria) this;
        }

        public Criteria andCrtUserIsNotNull() {
            addCriterion("CRT_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCrtUserEqualTo(String value) {
            addCriterion("CRT_USER =", value, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserNotEqualTo(String value) {
            addCriterion("CRT_USER <>", value, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserGreaterThan(String value) {
            addCriterion("CRT_USER >", value, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserGreaterThanOrEqualTo(String value) {
            addCriterion("CRT_USER >=", value, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserLessThan(String value) {
            addCriterion("CRT_USER <", value, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserLessThanOrEqualTo(String value) {
            addCriterion("CRT_USER <=", value, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserLike(String value) {
            addCriterion("CRT_USER like", value, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserNotLike(String value) {
            addCriterion("CRT_USER not like", value, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserIn(List<String> values) {
            addCriterion("CRT_USER in", values, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserNotIn(List<String> values) {
            addCriterion("CRT_USER not in", values, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserBetween(String value1, String value2) {
            addCriterion("CRT_USER between", value1, value2, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtUserNotBetween(String value1, String value2) {
            addCriterion("CRT_USER not between", value1, value2, "crtUser");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNull() {
            addCriterion("CRT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("CRT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CRT_TIME =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CRT_TIME <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CRT_TIME >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CRT_TIME >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterionForJDBCDate("CRT_TIME <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CRT_TIME <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CRT_TIME in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CRT_TIME not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CRT_TIME between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CRT_TIME not between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("` CHANNEL_ID` is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("` CHANNEL_ID` is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("` CHANNEL_ID` =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("` CHANNEL_ID` <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("` CHANNEL_ID` >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("` CHANNEL_ID` >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("` CHANNEL_ID` <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("` CHANNEL_ID` <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Long> values) {
            addCriterion("` CHANNEL_ID` in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Long> values) {
            addCriterion("` CHANNEL_ID` not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("` CHANNEL_ID` between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("` CHANNEL_ID` not between", value1, value2, "channelId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}