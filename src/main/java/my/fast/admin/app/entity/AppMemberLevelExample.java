package my.fast.admin.app.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppMemberLevelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppMemberLevelExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMembersNameIsNull() {
            addCriterion("members_name is null");
            return (Criteria) this;
        }

        public Criteria andMembersNameIsNotNull() {
            addCriterion("members_name is not null");
            return (Criteria) this;
        }

        public Criteria andMembersNameEqualTo(String value) {
            addCriterion("members_name =", value, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameNotEqualTo(String value) {
            addCriterion("members_name <>", value, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameGreaterThan(String value) {
            addCriterion("members_name >", value, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameGreaterThanOrEqualTo(String value) {
            addCriterion("members_name >=", value, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameLessThan(String value) {
            addCriterion("members_name <", value, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameLessThanOrEqualTo(String value) {
            addCriterion("members_name <=", value, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameLike(String value) {
            addCriterion("members_name like", value, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameNotLike(String value) {
            addCriterion("members_name not like", value, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameIn(List<String> values) {
            addCriterion("members_name in", values, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameNotIn(List<String> values) {
            addCriterion("members_name not in", values, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameBetween(String value1, String value2) {
            addCriterion("members_name between", value1, value2, "membersName");
            return (Criteria) this;
        }

        public Criteria andMembersNameNotBetween(String value1, String value2) {
            addCriterion("members_name not between", value1, value2, "membersName");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Integer value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Integer value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Integer value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Integer value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Integer> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Integer> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIsNull() {
            addCriterion("member_price is null");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIsNotNull() {
            addCriterion("member_price is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPriceEqualTo(BigDecimal value) {
            addCriterion("member_price =", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotEqualTo(BigDecimal value) {
            addCriterion("member_price <>", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceGreaterThan(BigDecimal value) {
            addCriterion("member_price >", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("member_price >=", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceLessThan(BigDecimal value) {
            addCriterion("member_price <", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("member_price <=", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIn(List<BigDecimal> values) {
            addCriterion("member_price in", values, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotIn(List<BigDecimal> values) {
            addCriterion("member_price not in", values, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_price between", value1, value2, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_price not between", value1, value2, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(Date value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(Date value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(Date value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(Date value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(Date value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(Date value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<Date> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<Date> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(Date value1, Date value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(Date value1, Date value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andMembersLevelIsNull() {
            addCriterion("members_level is null");
            return (Criteria) this;
        }

        public Criteria andMembersLevelIsNotNull() {
            addCriterion("members_level is not null");
            return (Criteria) this;
        }

        public Criteria andMembersLevelEqualTo(Integer value) {
            addCriterion("members_level =", value, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelNotEqualTo(Integer value) {
            addCriterion("members_level <>", value, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelGreaterThan(Integer value) {
            addCriterion("members_level >", value, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("members_level >=", value, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelLessThan(Integer value) {
            addCriterion("members_level <", value, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelLessThanOrEqualTo(Integer value) {
            addCriterion("members_level <=", value, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelIn(List<Integer> values) {
            addCriterion("members_level in", values, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelNotIn(List<Integer> values) {
            addCriterion("members_level not in", values, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelBetween(Integer value1, Integer value2) {
            addCriterion("members_level between", value1, value2, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andMembersLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("members_level not between", value1, value2, "membersLevel");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesIsNull() {
            addCriterion("withdrawal_times is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesIsNotNull() {
            addCriterion("withdrawal_times is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesEqualTo(Integer value) {
            addCriterion("withdrawal_times =", value, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesNotEqualTo(Integer value) {
            addCriterion("withdrawal_times <>", value, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesGreaterThan(Integer value) {
            addCriterion("withdrawal_times >", value, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_times >=", value, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesLessThan(Integer value) {
            addCriterion("withdrawal_times <", value, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesLessThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_times <=", value, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesIn(List<Integer> values) {
            addCriterion("withdrawal_times in", values, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesNotIn(List<Integer> values) {
            addCriterion("withdrawal_times not in", values, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_times between", value1, value2, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_times not between", value1, value2, "withdrawalTimes");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinIsNull() {
            addCriterion("withdrawal_min is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinIsNotNull() {
            addCriterion("withdrawal_min is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinEqualTo(Integer value) {
            addCriterion("withdrawal_min =", value, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinNotEqualTo(Integer value) {
            addCriterion("withdrawal_min <>", value, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinGreaterThan(Integer value) {
            addCriterion("withdrawal_min >", value, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_min >=", value, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinLessThan(Integer value) {
            addCriterion("withdrawal_min <", value, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinLessThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_min <=", value, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinIn(List<Integer> values) {
            addCriterion("withdrawal_min in", values, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinNotIn(List<Integer> values) {
            addCriterion("withdrawal_min not in", values, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_min between", value1, value2, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMinNotBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_min not between", value1, value2, "withdrawalMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxIsNull() {
            addCriterion("withdrawal_max is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxIsNotNull() {
            addCriterion("withdrawal_max is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxEqualTo(Integer value) {
            addCriterion("withdrawal_max =", value, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxNotEqualTo(Integer value) {
            addCriterion("withdrawal_max <>", value, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxGreaterThan(Integer value) {
            addCriterion("withdrawal_max >", value, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_max >=", value, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxLessThan(Integer value) {
            addCriterion("withdrawal_max <", value, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxLessThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_max <=", value, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxIn(List<Integer> values) {
            addCriterion("withdrawal_max in", values, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxNotIn(List<Integer> values) {
            addCriterion("withdrawal_max not in", values, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_max between", value1, value2, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andWithdrawalMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_max not between", value1, value2, "withdrawalMax");
            return (Criteria) this;
        }

        public Criteria andNumMinIsNull() {
            addCriterion("num_min is null");
            return (Criteria) this;
        }

        public Criteria andNumMinIsNotNull() {
            addCriterion("num_min is not null");
            return (Criteria) this;
        }

        public Criteria andNumMinEqualTo(Integer value) {
            addCriterion("num_min =", value, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinNotEqualTo(Integer value) {
            addCriterion("num_min <>", value, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinGreaterThan(Integer value) {
            addCriterion("num_min >", value, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_min >=", value, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinLessThan(Integer value) {
            addCriterion("num_min <", value, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinLessThanOrEqualTo(Integer value) {
            addCriterion("num_min <=", value, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinIn(List<Integer> values) {
            addCriterion("num_min in", values, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinNotIn(List<Integer> values) {
            addCriterion("num_min not in", values, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinBetween(Integer value1, Integer value2) {
            addCriterion("num_min between", value1, value2, "numMin");
            return (Criteria) this;
        }

        public Criteria andNumMinNotBetween(Integer value1, Integer value2) {
            addCriterion("num_min not between", value1, value2, "numMin");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderIsNull() {
            addCriterion("withdrawal_nim_order is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderIsNotNull() {
            addCriterion("withdrawal_nim_order is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderEqualTo(Integer value) {
            addCriterion("withdrawal_nim_order =", value, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderNotEqualTo(Integer value) {
            addCriterion("withdrawal_nim_order <>", value, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderGreaterThan(Integer value) {
            addCriterion("withdrawal_nim_order >", value, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_nim_order >=", value, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderLessThan(Integer value) {
            addCriterion("withdrawal_nim_order <", value, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderLessThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_nim_order <=", value, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderIn(List<Integer> values) {
            addCriterion("withdrawal_nim_order in", values, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderNotIn(List<Integer> values) {
            addCriterion("withdrawal_nim_order not in", values, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_nim_order between", value1, value2, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andWithdrawalNimOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_nim_order not between", value1, value2, "withdrawalNimOrder");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumIsNull() {
            addCriterion("auto_vip_xu_num is null");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumIsNotNull() {
            addCriterion("auto_vip_xu_num is not null");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumEqualTo(Integer value) {
            addCriterion("auto_vip_xu_num =", value, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumNotEqualTo(Integer value) {
            addCriterion("auto_vip_xu_num <>", value, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumGreaterThan(Integer value) {
            addCriterion("auto_vip_xu_num >", value, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_vip_xu_num >=", value, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumLessThan(Integer value) {
            addCriterion("auto_vip_xu_num <", value, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumLessThanOrEqualTo(Integer value) {
            addCriterion("auto_vip_xu_num <=", value, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumIn(List<Integer> values) {
            addCriterion("auto_vip_xu_num in", values, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumNotIn(List<Integer> values) {
            addCriterion("auto_vip_xu_num not in", values, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumBetween(Integer value1, Integer value2) {
            addCriterion("auto_vip_xu_num between", value1, value2, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andAutoVipXuNumNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_vip_xu_num not between", value1, value2, "autoVipXuNum");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNull() {
            addCriterion("service_charge is null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNotNull() {
            addCriterion("service_charge is not null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeEqualTo(BigDecimal value) {
            addCriterion("service_charge =", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotEqualTo(BigDecimal value) {
            addCriterion("service_charge <>", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThan(BigDecimal value) {
            addCriterion("service_charge >", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_charge >=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThan(BigDecimal value) {
            addCriterion("service_charge <", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_charge <=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIn(List<BigDecimal> values) {
            addCriterion("service_charge in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotIn(List<BigDecimal> values) {
            addCriterion("service_charge not in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_charge between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_charge not between", value1, value2, "serviceCharge");
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