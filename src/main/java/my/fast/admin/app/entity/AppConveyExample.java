package com.macro.mall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppConveyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppConveyExample() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("ADDTIME is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("ADDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(String value) {
            addCriterion("ADDTIME =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(String value) {
            addCriterion("ADDTIME <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(String value) {
            addCriterion("ADDTIME >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ADDTIME >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(String value) {
            addCriterion("ADDTIME <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(String value) {
            addCriterion("ADDTIME <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLike(String value) {
            addCriterion("ADDTIME like", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotLike(String value) {
            addCriterion("ADDTIME not like", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<String> values) {
            addCriterion("ADDTIME in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<String> values) {
            addCriterion("ADDTIME not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(String value1, String value2) {
            addCriterion("ADDTIME between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(String value1, String value2) {
            addCriterion("ADDTIME not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("ENDTIME like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("ENDTIME not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("ENDTIME not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("COMMISSION is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("COMMISSION is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("COMMISSION =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("COMMISSION <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("COMMISSION >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMISSION >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("COMMISSION <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMISSION <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("COMMISSION in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("COMMISSION not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMISSION between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMISSION not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCStatusIsNull() {
            addCriterion("C_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCStatusIsNotNull() {
            addCriterion("C_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCStatusEqualTo(String value) {
            addCriterion("C_STATUS =", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotEqualTo(String value) {
            addCriterion("C_STATUS <>", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusGreaterThan(String value) {
            addCriterion("C_STATUS >", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusGreaterThanOrEqualTo(String value) {
            addCriterion("C_STATUS >=", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusLessThan(String value) {
            addCriterion("C_STATUS <", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusLessThanOrEqualTo(String value) {
            addCriterion("C_STATUS <=", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusLike(String value) {
            addCriterion("C_STATUS like", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotLike(String value) {
            addCriterion("C_STATUS not like", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusIn(List<String> values) {
            addCriterion("C_STATUS in", values, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotIn(List<String> values) {
            addCriterion("C_STATUS not in", values, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusBetween(String value1, String value2) {
            addCriterion("C_STATUS between", value1, value2, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotBetween(String value1, String value2) {
            addCriterion("C_STATUS not between", value1, value2, "cStatus");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNull() {
            addCriterion("ADD_ID is null");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNotNull() {
            addCriterion("ADD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAddIdEqualTo(Long value) {
            addCriterion("ADD_ID =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotEqualTo(Long value) {
            addCriterion("ADD_ID <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThan(Long value) {
            addCriterion("ADD_ID >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ADD_ID >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThan(Long value) {
            addCriterion("ADD_ID <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThanOrEqualTo(Long value) {
            addCriterion("ADD_ID <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdIn(List<Long> values) {
            addCriterion("ADD_ID in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotIn(List<Long> values) {
            addCriterion("ADD_ID not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdBetween(Long value1, Long value2) {
            addCriterion("ADD_ID between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotBetween(Long value1, Long value2) {
            addCriterion("ADD_ID not between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("GOODS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("GOODS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("GOODS_ID =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("GOODS_ID <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("GOODS_ID >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("GOODS_ID >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("GOODS_ID <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("GOODS_ID <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("GOODS_ID in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("GOODS_ID not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("GOODS_ID between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("GOODS_ID not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNull() {
            addCriterion("GOODS_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addCriterion("GOODS_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(String value) {
            addCriterion("GOODS_COUNT =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(String value) {
            addCriterion("GOODS_COUNT <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(String value) {
            addCriterion("GOODS_COUNT >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_COUNT >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(String value) {
            addCriterion("GOODS_COUNT <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(String value) {
            addCriterion("GOODS_COUNT <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLike(String value) {
            addCriterion("GOODS_COUNT like", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotLike(String value) {
            addCriterion("GOODS_COUNT not like", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<String> values) {
            addCriterion("GOODS_COUNT in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<String> values) {
            addCriterion("GOODS_COUNT not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(String value1, String value2) {
            addCriterion("GOODS_COUNT between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(String value1, String value2) {
            addCriterion("GOODS_COUNT not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andHidIsNull() {
            addCriterion("HID is null");
            return (Criteria) this;
        }

        public Criteria andHidIsNotNull() {
            addCriterion("HID is not null");
            return (Criteria) this;
        }

        public Criteria andHidEqualTo(String value) {
            addCriterion("HID =", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotEqualTo(String value) {
            addCriterion("HID <>", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThan(String value) {
            addCriterion("HID >", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThanOrEqualTo(String value) {
            addCriterion("HID >=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThan(String value) {
            addCriterion("HID <", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThanOrEqualTo(String value) {
            addCriterion("HID <=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLike(String value) {
            addCriterion("HID like", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotLike(String value) {
            addCriterion("HID not like", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidIn(List<String> values) {
            addCriterion("HID in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotIn(List<String> values) {
            addCriterion("HID not in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidBetween(String value1, String value2) {
            addCriterion("HID between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotBetween(String value1, String value2) {
            addCriterion("HID not between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andSanIsNull() {
            addCriterion("SAN is null");
            return (Criteria) this;
        }

        public Criteria andSanIsNotNull() {
            addCriterion("SAN is not null");
            return (Criteria) this;
        }

        public Criteria andSanEqualTo(String value) {
            addCriterion("SAN =", value, "san");
            return (Criteria) this;
        }

        public Criteria andSanNotEqualTo(String value) {
            addCriterion("SAN <>", value, "san");
            return (Criteria) this;
        }

        public Criteria andSanGreaterThan(String value) {
            addCriterion("SAN >", value, "san");
            return (Criteria) this;
        }

        public Criteria andSanGreaterThanOrEqualTo(String value) {
            addCriterion("SAN >=", value, "san");
            return (Criteria) this;
        }

        public Criteria andSanLessThan(String value) {
            addCriterion("SAN <", value, "san");
            return (Criteria) this;
        }

        public Criteria andSanLessThanOrEqualTo(String value) {
            addCriterion("SAN <=", value, "san");
            return (Criteria) this;
        }

        public Criteria andSanLike(String value) {
            addCriterion("SAN like", value, "san");
            return (Criteria) this;
        }

        public Criteria andSanNotLike(String value) {
            addCriterion("SAN not like", value, "san");
            return (Criteria) this;
        }

        public Criteria andSanIn(List<String> values) {
            addCriterion("SAN in", values, "san");
            return (Criteria) this;
        }

        public Criteria andSanNotIn(List<String> values) {
            addCriterion("SAN not in", values, "san");
            return (Criteria) this;
        }

        public Criteria andSanBetween(String value1, String value2) {
            addCriterion("SAN between", value1, value2, "san");
            return (Criteria) this;
        }

        public Criteria andSanNotBetween(String value1, String value2) {
            addCriterion("SAN not between", value1, value2, "san");
            return (Criteria) this;
        }

        public Criteria andQiangIsNull() {
            addCriterion("QIANG is null");
            return (Criteria) this;
        }

        public Criteria andQiangIsNotNull() {
            addCriterion("QIANG is not null");
            return (Criteria) this;
        }

        public Criteria andQiangEqualTo(String value) {
            addCriterion("QIANG =", value, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangNotEqualTo(String value) {
            addCriterion("QIANG <>", value, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangGreaterThan(String value) {
            addCriterion("QIANG >", value, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangGreaterThanOrEqualTo(String value) {
            addCriterion("QIANG >=", value, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangLessThan(String value) {
            addCriterion("QIANG <", value, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangLessThanOrEqualTo(String value) {
            addCriterion("QIANG <=", value, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangLike(String value) {
            addCriterion("QIANG like", value, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangNotLike(String value) {
            addCriterion("QIANG not like", value, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangIn(List<String> values) {
            addCriterion("QIANG in", values, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangNotIn(List<String> values) {
            addCriterion("QIANG not in", values, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangBetween(String value1, String value2) {
            addCriterion("QIANG between", value1, value2, "qiang");
            return (Criteria) this;
        }

        public Criteria andQiangNotBetween(String value1, String value2) {
            addCriterion("QIANG not between", value1, value2, "qiang");
            return (Criteria) this;
        }

        public Criteria andLiandannoIsNull() {
            addCriterion("LIANDANNO is null");
            return (Criteria) this;
        }

        public Criteria andLiandannoIsNotNull() {
            addCriterion("LIANDANNO is not null");
            return (Criteria) this;
        }

        public Criteria andLiandannoEqualTo(String value) {
            addCriterion("LIANDANNO =", value, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoNotEqualTo(String value) {
            addCriterion("LIANDANNO <>", value, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoGreaterThan(String value) {
            addCriterion("LIANDANNO >", value, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoGreaterThanOrEqualTo(String value) {
            addCriterion("LIANDANNO >=", value, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoLessThan(String value) {
            addCriterion("LIANDANNO <", value, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoLessThanOrEqualTo(String value) {
            addCriterion("LIANDANNO <=", value, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoLike(String value) {
            addCriterion("LIANDANNO like", value, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoNotLike(String value) {
            addCriterion("LIANDANNO not like", value, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoIn(List<String> values) {
            addCriterion("LIANDANNO in", values, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoNotIn(List<String> values) {
            addCriterion("LIANDANNO not in", values, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoBetween(String value1, String value2) {
            addCriterion("LIANDANNO between", value1, value2, "liandanno");
            return (Criteria) this;
        }

        public Criteria andLiandannoNotBetween(String value1, String value2) {
            addCriterion("LIANDANNO not between", value1, value2, "liandanno");
            return (Criteria) this;
        }

        public Criteria andIsliandanIsNull() {
            addCriterion("ISLIANDAN is null");
            return (Criteria) this;
        }

        public Criteria andIsliandanIsNotNull() {
            addCriterion("ISLIANDAN is not null");
            return (Criteria) this;
        }

        public Criteria andIsliandanEqualTo(String value) {
            addCriterion("ISLIANDAN =", value, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanNotEqualTo(String value) {
            addCriterion("ISLIANDAN <>", value, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanGreaterThan(String value) {
            addCriterion("ISLIANDAN >", value, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanGreaterThanOrEqualTo(String value) {
            addCriterion("ISLIANDAN >=", value, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanLessThan(String value) {
            addCriterion("ISLIANDAN <", value, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanLessThanOrEqualTo(String value) {
            addCriterion("ISLIANDAN <=", value, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanLike(String value) {
            addCriterion("ISLIANDAN like", value, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanNotLike(String value) {
            addCriterion("ISLIANDAN not like", value, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanIn(List<String> values) {
            addCriterion("ISLIANDAN in", values, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanNotIn(List<String> values) {
            addCriterion("ISLIANDAN not in", values, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanBetween(String value1, String value2) {
            addCriterion("ISLIANDAN between", value1, value2, "isliandan");
            return (Criteria) this;
        }

        public Criteria andIsliandanNotBetween(String value1, String value2) {
            addCriterion("ISLIANDAN not between", value1, value2, "isliandan");
            return (Criteria) this;
        }

        public Criteria andLidIsNull() {
            addCriterion("LID is null");
            return (Criteria) this;
        }

        public Criteria andLidIsNotNull() {
            addCriterion("LID is not null");
            return (Criteria) this;
        }

        public Criteria andLidEqualTo(String value) {
            addCriterion("LID =", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotEqualTo(String value) {
            addCriterion("LID <>", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThan(String value) {
            addCriterion("LID >", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThanOrEqualTo(String value) {
            addCriterion("LID >=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThan(String value) {
            addCriterion("LID <", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThanOrEqualTo(String value) {
            addCriterion("LID <=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLike(String value) {
            addCriterion("LID like", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotLike(String value) {
            addCriterion("LID not like", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidIn(List<String> values) {
            addCriterion("LID in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotIn(List<String> values) {
            addCriterion("LID not in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidBetween(String value1, String value2) {
            addCriterion("LID between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotBetween(String value1, String value2) {
            addCriterion("LID not between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLnoIsNull() {
            addCriterion("LNO is null");
            return (Criteria) this;
        }

        public Criteria andLnoIsNotNull() {
            addCriterion("LNO is not null");
            return (Criteria) this;
        }

        public Criteria andLnoEqualTo(String value) {
            addCriterion("LNO =", value, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoNotEqualTo(String value) {
            addCriterion("LNO <>", value, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoGreaterThan(String value) {
            addCriterion("LNO >", value, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoGreaterThanOrEqualTo(String value) {
            addCriterion("LNO >=", value, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoLessThan(String value) {
            addCriterion("LNO <", value, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoLessThanOrEqualTo(String value) {
            addCriterion("LNO <=", value, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoLike(String value) {
            addCriterion("LNO like", value, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoNotLike(String value) {
            addCriterion("LNO not like", value, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoIn(List<String> values) {
            addCriterion("LNO in", values, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoNotIn(List<String> values) {
            addCriterion("LNO not in", values, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoBetween(String value1, String value2) {
            addCriterion("LNO between", value1, value2, "lno");
            return (Criteria) this;
        }

        public Criteria andLnoNotBetween(String value1, String value2) {
            addCriterion("LNO not between", value1, value2, "lno");
            return (Criteria) this;
        }

        public Criteria andMinIsNull() {
            addCriterion("MIN is null");
            return (Criteria) this;
        }

        public Criteria andMinIsNotNull() {
            addCriterion("MIN is not null");
            return (Criteria) this;
        }

        public Criteria andMinEqualTo(BigDecimal value) {
            addCriterion("MIN =", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotEqualTo(BigDecimal value) {
            addCriterion("MIN <>", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThan(BigDecimal value) {
            addCriterion("MIN >", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN >=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThan(BigDecimal value) {
            addCriterion("MIN <", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN <=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinIn(List<BigDecimal> values) {
            addCriterion("MIN in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotIn(List<BigDecimal> values) {
            addCriterion("MIN not in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN not between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMaxIsNull() {
            addCriterion("MAX is null");
            return (Criteria) this;
        }

        public Criteria andMaxIsNotNull() {
            addCriterion("MAX is not null");
            return (Criteria) this;
        }

        public Criteria andMaxEqualTo(BigDecimal value) {
            addCriterion("MAX =", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotEqualTo(BigDecimal value) {
            addCriterion("MAX <>", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxGreaterThan(BigDecimal value) {
            addCriterion("MAX >", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX >=", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxLessThan(BigDecimal value) {
            addCriterion("MAX <", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX <=", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxIn(List<BigDecimal> values) {
            addCriterion("MAX in", values, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotIn(List<BigDecimal> values) {
            addCriterion("MAX not in", values, "max");
            return (Criteria) this;
        }

        public Criteria andMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX between", value1, value2, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX not between", value1, value2, "max");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("SIGN is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("SIGN =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("SIGN <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("SIGN >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("SIGN <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("SIGN <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("SIGN like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("SIGN not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("SIGN in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("SIGN not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("SIGN between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("SIGN not between", value1, value2, "sign");
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