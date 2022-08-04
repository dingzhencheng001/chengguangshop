package my.fast.admin.cg.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppControlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppControlExample() {
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

        public Criteria andTrcIsNull() {
            addCriterion("trc is null");
            return (Criteria) this;
        }

        public Criteria andTrcIsNotNull() {
            addCriterion("trc is not null");
            return (Criteria) this;
        }

        public Criteria andTrcEqualTo(String value) {
            addCriterion("trc =", value, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcNotEqualTo(String value) {
            addCriterion("trc <>", value, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcGreaterThan(String value) {
            addCriterion("trc >", value, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcGreaterThanOrEqualTo(String value) {
            addCriterion("trc >=", value, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcLessThan(String value) {
            addCriterion("trc <", value, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcLessThanOrEqualTo(String value) {
            addCriterion("trc <=", value, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcLike(String value) {
            addCriterion("trc like", value, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcNotLike(String value) {
            addCriterion("trc not like", value, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcIn(List<String> values) {
            addCriterion("trc in", values, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcNotIn(List<String> values) {
            addCriterion("trc not in", values, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcBetween(String value1, String value2) {
            addCriterion("trc between", value1, value2, "trc");
            return (Criteria) this;
        }

        public Criteria andTrcNotBetween(String value1, String value2) {
            addCriterion("trc not between", value1, value2, "trc");
            return (Criteria) this;
        }

        public Criteria andErcIsNull() {
            addCriterion("erc is null");
            return (Criteria) this;
        }

        public Criteria andErcIsNotNull() {
            addCriterion("erc is not null");
            return (Criteria) this;
        }

        public Criteria andErcEqualTo(String value) {
            addCriterion("erc =", value, "erc");
            return (Criteria) this;
        }

        public Criteria andErcNotEqualTo(String value) {
            addCriterion("erc <>", value, "erc");
            return (Criteria) this;
        }

        public Criteria andErcGreaterThan(String value) {
            addCriterion("erc >", value, "erc");
            return (Criteria) this;
        }

        public Criteria andErcGreaterThanOrEqualTo(String value) {
            addCriterion("erc >=", value, "erc");
            return (Criteria) this;
        }

        public Criteria andErcLessThan(String value) {
            addCriterion("erc <", value, "erc");
            return (Criteria) this;
        }

        public Criteria andErcLessThanOrEqualTo(String value) {
            addCriterion("erc <=", value, "erc");
            return (Criteria) this;
        }

        public Criteria andErcLike(String value) {
            addCriterion("erc like", value, "erc");
            return (Criteria) this;
        }

        public Criteria andErcNotLike(String value) {
            addCriterion("erc not like", value, "erc");
            return (Criteria) this;
        }

        public Criteria andErcIn(List<String> values) {
            addCriterion("erc in", values, "erc");
            return (Criteria) this;
        }

        public Criteria andErcNotIn(List<String> values) {
            addCriterion("erc not in", values, "erc");
            return (Criteria) this;
        }

        public Criteria andErcBetween(String value1, String value2) {
            addCriterion("erc between", value1, value2, "erc");
            return (Criteria) this;
        }

        public Criteria andErcNotBetween(String value1, String value2) {
            addCriterion("erc not between", value1, value2, "erc");
            return (Criteria) this;
        }

        public Criteria andUsdtIsNull() {
            addCriterion("usdt is null");
            return (Criteria) this;
        }

        public Criteria andUsdtIsNotNull() {
            addCriterion("usdt is not null");
            return (Criteria) this;
        }

        public Criteria andUsdtEqualTo(String value) {
            addCriterion("usdt =", value, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtNotEqualTo(String value) {
            addCriterion("usdt <>", value, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtGreaterThan(String value) {
            addCriterion("usdt >", value, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtGreaterThanOrEqualTo(String value) {
            addCriterion("usdt >=", value, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtLessThan(String value) {
            addCriterion("usdt <", value, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtLessThanOrEqualTo(String value) {
            addCriterion("usdt <=", value, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtLike(String value) {
            addCriterion("usdt like", value, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtNotLike(String value) {
            addCriterion("usdt not like", value, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtIn(List<String> values) {
            addCriterion("usdt in", values, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtNotIn(List<String> values) {
            addCriterion("usdt not in", values, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtBetween(String value1, String value2) {
            addCriterion("usdt between", value1, value2, "usdt");
            return (Criteria) this;
        }

        public Criteria andUsdtNotBetween(String value1, String value2) {
            addCriterion("usdt not between", value1, value2, "usdt");
            return (Criteria) this;
        }

        public Criteria andDealAmountIsNull() {
            addCriterion("deal_amount is null");
            return (Criteria) this;
        }

        public Criteria andDealAmountIsNotNull() {
            addCriterion("deal_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDealAmountEqualTo(BigDecimal value) {
            addCriterion("deal_amount =", value, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountNotEqualTo(BigDecimal value) {
            addCriterion("deal_amount <>", value, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountGreaterThan(BigDecimal value) {
            addCriterion("deal_amount >", value, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deal_amount >=", value, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountLessThan(BigDecimal value) {
            addCriterion("deal_amount <", value, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deal_amount <=", value, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountIn(List<BigDecimal> values) {
            addCriterion("deal_amount in", values, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountNotIn(List<BigDecimal> values) {
            addCriterion("deal_amount not in", values, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deal_amount between", value1, value2, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andDealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deal_amount not between", value1, value2, "dealAmount");
            return (Criteria) this;
        }

        public Criteria andWaitIsNull() {
            addCriterion("wait is null");
            return (Criteria) this;
        }

        public Criteria andWaitIsNotNull() {
            addCriterion("wait is not null");
            return (Criteria) this;
        }

        public Criteria andWaitEqualTo(Integer value) {
            addCriterion("wait =", value, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitNotEqualTo(Integer value) {
            addCriterion("wait <>", value, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitGreaterThan(Integer value) {
            addCriterion("wait >", value, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitGreaterThanOrEqualTo(Integer value) {
            addCriterion("wait >=", value, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitLessThan(Integer value) {
            addCriterion("wait <", value, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitLessThanOrEqualTo(Integer value) {
            addCriterion("wait <=", value, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitIn(List<Integer> values) {
            addCriterion("wait in", values, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitNotIn(List<Integer> values) {
            addCriterion("wait not in", values, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitBetween(Integer value1, Integer value2) {
            addCriterion("wait between", value1, value2, "wait");
            return (Criteria) this;
        }

        public Criteria andWaitNotBetween(Integer value1, Integer value2) {
            addCriterion("wait not between", value1, value2, "wait");
            return (Criteria) this;
        }

        public Criteria andStartRangIsNull() {
            addCriterion("start_rang is null");
            return (Criteria) this;
        }

        public Criteria andStartRangIsNotNull() {
            addCriterion("start_rang is not null");
            return (Criteria) this;
        }

        public Criteria andStartRangEqualTo(Integer value) {
            addCriterion("start_rang =", value, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangNotEqualTo(Integer value) {
            addCriterion("start_rang <>", value, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangGreaterThan(Integer value) {
            addCriterion("start_rang >", value, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_rang >=", value, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangLessThan(Integer value) {
            addCriterion("start_rang <", value, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangLessThanOrEqualTo(Integer value) {
            addCriterion("start_rang <=", value, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangIn(List<Integer> values) {
            addCriterion("start_rang in", values, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangNotIn(List<Integer> values) {
            addCriterion("start_rang not in", values, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangBetween(Integer value1, Integer value2) {
            addCriterion("start_rang between", value1, value2, "startRang");
            return (Criteria) this;
        }

        public Criteria andStartRangNotBetween(Integer value1, Integer value2) {
            addCriterion("start_rang not between", value1, value2, "startRang");
            return (Criteria) this;
        }

        public Criteria andEndRangIsNull() {
            addCriterion("end_rang is null");
            return (Criteria) this;
        }

        public Criteria andEndRangIsNotNull() {
            addCriterion("end_rang is not null");
            return (Criteria) this;
        }

        public Criteria andEndRangEqualTo(Integer value) {
            addCriterion("end_rang =", value, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangNotEqualTo(Integer value) {
            addCriterion("end_rang <>", value, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangGreaterThan(Integer value) {
            addCriterion("end_rang >", value, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_rang >=", value, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangLessThan(Integer value) {
            addCriterion("end_rang <", value, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangLessThanOrEqualTo(Integer value) {
            addCriterion("end_rang <=", value, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangIn(List<Integer> values) {
            addCriterion("end_rang in", values, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangNotIn(List<Integer> values) {
            addCriterion("end_rang not in", values, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangBetween(Integer value1, Integer value2) {
            addCriterion("end_rang between", value1, value2, "endRang");
            return (Criteria) this;
        }

        public Criteria andEndRangNotBetween(Integer value1, Integer value2) {
            addCriterion("end_rang not between", value1, value2, "endRang");
            return (Criteria) this;
        }

        public Criteria andTradeNumIsNull() {
            addCriterion("trade_num is null");
            return (Criteria) this;
        }

        public Criteria andTradeNumIsNotNull() {
            addCriterion("trade_num is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNumEqualTo(Integer value) {
            addCriterion("trade_num =", value, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumNotEqualTo(Integer value) {
            addCriterion("trade_num <>", value, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumGreaterThan(Integer value) {
            addCriterion("trade_num >", value, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_num >=", value, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumLessThan(Integer value) {
            addCriterion("trade_num <", value, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumLessThanOrEqualTo(Integer value) {
            addCriterion("trade_num <=", value, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumIn(List<Integer> values) {
            addCriterion("trade_num in", values, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumNotIn(List<Integer> values) {
            addCriterion("trade_num not in", values, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumBetween(Integer value1, Integer value2) {
            addCriterion("trade_num between", value1, value2, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andTradeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_num not between", value1, value2, "tradeNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumIsNull() {
            addCriterion("reward_num is null");
            return (Criteria) this;
        }

        public Criteria andRewardNumIsNotNull() {
            addCriterion("reward_num is not null");
            return (Criteria) this;
        }

        public Criteria andRewardNumEqualTo(Integer value) {
            addCriterion("reward_num =", value, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumNotEqualTo(Integer value) {
            addCriterion("reward_num <>", value, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumGreaterThan(Integer value) {
            addCriterion("reward_num >", value, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("reward_num >=", value, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumLessThan(Integer value) {
            addCriterion("reward_num <", value, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumLessThanOrEqualTo(Integer value) {
            addCriterion("reward_num <=", value, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumIn(List<Integer> values) {
            addCriterion("reward_num in", values, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumNotIn(List<Integer> values) {
            addCriterion("reward_num not in", values, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumBetween(Integer value1, Integer value2) {
            addCriterion("reward_num between", value1, value2, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andRewardNumNotBetween(Integer value1, Integer value2) {
            addCriterion("reward_num not between", value1, value2, "rewardNum");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionIsNull() {
            addCriterion("general_commission is null");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionIsNotNull() {
            addCriterion("general_commission is not null");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionEqualTo(BigDecimal value) {
            addCriterion("general_commission =", value, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionNotEqualTo(BigDecimal value) {
            addCriterion("general_commission <>", value, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionGreaterThan(BigDecimal value) {
            addCriterion("general_commission >", value, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("general_commission >=", value, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionLessThan(BigDecimal value) {
            addCriterion("general_commission <", value, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("general_commission <=", value, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionIn(List<BigDecimal> values) {
            addCriterion("general_commission in", values, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionNotIn(List<BigDecimal> values) {
            addCriterion("general_commission not in", values, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("general_commission between", value1, value2, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andGeneralCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("general_commission not between", value1, value2, "generalCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionIsNull() {
            addCriterion("up_one_commission is null");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionIsNotNull() {
            addCriterion("up_one_commission is not null");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionEqualTo(BigDecimal value) {
            addCriterion("up_one_commission =", value, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionNotEqualTo(BigDecimal value) {
            addCriterion("up_one_commission <>", value, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionGreaterThan(BigDecimal value) {
            addCriterion("up_one_commission >", value, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("up_one_commission >=", value, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionLessThan(BigDecimal value) {
            addCriterion("up_one_commission <", value, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("up_one_commission <=", value, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionIn(List<BigDecimal> values) {
            addCriterion("up_one_commission in", values, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionNotIn(List<BigDecimal> values) {
            addCriterion("up_one_commission not in", values, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_one_commission between", value1, value2, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpOneCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_one_commission not between", value1, value2, "upOneCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionIsNull() {
            addCriterion("up_two_commission is null");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionIsNotNull() {
            addCriterion("up_two_commission is not null");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionEqualTo(BigDecimal value) {
            addCriterion("up_two_commission =", value, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionNotEqualTo(BigDecimal value) {
            addCriterion("up_two_commission <>", value, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionGreaterThan(BigDecimal value) {
            addCriterion("up_two_commission >", value, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("up_two_commission >=", value, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionLessThan(BigDecimal value) {
            addCriterion("up_two_commission <", value, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("up_two_commission <=", value, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionIn(List<BigDecimal> values) {
            addCriterion("up_two_commission in", values, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionNotIn(List<BigDecimal> values) {
            addCriterion("up_two_commission not in", values, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_two_commission between", value1, value2, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpTwoCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_two_commission not between", value1, value2, "upTwoCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionIsNull() {
            addCriterion("up_three_commission is null");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionIsNotNull() {
            addCriterion("up_three_commission is not null");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionEqualTo(BigDecimal value) {
            addCriterion("up_three_commission =", value, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionNotEqualTo(BigDecimal value) {
            addCriterion("up_three_commission <>", value, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionGreaterThan(BigDecimal value) {
            addCriterion("up_three_commission >", value, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("up_three_commission >=", value, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionLessThan(BigDecimal value) {
            addCriterion("up_three_commission <", value, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("up_three_commission <=", value, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionIn(List<BigDecimal> values) {
            addCriterion("up_three_commission in", values, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionNotIn(List<BigDecimal> values) {
            addCriterion("up_three_commission not in", values, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_three_commission between", value1, value2, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpThreeCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_three_commission not between", value1, value2, "upThreeCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionIsNull() {
            addCriterion("up_four_commission is null");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionIsNotNull() {
            addCriterion("up_four_commission is not null");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionEqualTo(BigDecimal value) {
            addCriterion("up_four_commission =", value, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionNotEqualTo(BigDecimal value) {
            addCriterion("up_four_commission <>", value, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionGreaterThan(BigDecimal value) {
            addCriterion("up_four_commission >", value, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("up_four_commission >=", value, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionLessThan(BigDecimal value) {
            addCriterion("up_four_commission <", value, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("up_four_commission <=", value, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionIn(List<BigDecimal> values) {
            addCriterion("up_four_commission in", values, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionNotIn(List<BigDecimal> values) {
            addCriterion("up_four_commission not in", values, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_four_commission between", value1, value2, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFourCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_four_commission not between", value1, value2, "upFourCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionIsNull() {
            addCriterion("up_five_commission is null");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionIsNotNull() {
            addCriterion("up_five_commission is not null");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionEqualTo(BigDecimal value) {
            addCriterion("up_five_commission =", value, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionNotEqualTo(BigDecimal value) {
            addCriterion("up_five_commission <>", value, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionGreaterThan(BigDecimal value) {
            addCriterion("up_five_commission >", value, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("up_five_commission >=", value, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionLessThan(BigDecimal value) {
            addCriterion("up_five_commission <", value, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("up_five_commission <=", value, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionIn(List<BigDecimal> values) {
            addCriterion("up_five_commission in", values, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionNotIn(List<BigDecimal> values) {
            addCriterion("up_five_commission not in", values, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_five_commission between", value1, value2, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andUpFiveCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_five_commission not between", value1, value2, "upFiveCommission");
            return (Criteria) this;
        }

        public Criteria andFreezeIsNull() {
            addCriterion("freeze is null");
            return (Criteria) this;
        }

        public Criteria andFreezeIsNotNull() {
            addCriterion("freeze is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeEqualTo(Integer value) {
            addCriterion("freeze =", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotEqualTo(Integer value) {
            addCriterion("freeze <>", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeGreaterThan(Integer value) {
            addCriterion("freeze >", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeze >=", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeLessThan(Integer value) {
            addCriterion("freeze <", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeLessThanOrEqualTo(Integer value) {
            addCriterion("freeze <=", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeIn(List<Integer> values) {
            addCriterion("freeze in", values, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotIn(List<Integer> values) {
            addCriterion("freeze not in", values, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeBetween(Integer value1, Integer value2) {
            addCriterion("freeze between", value1, value2, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotBetween(Integer value1, Integer value2) {
            addCriterion("freeze not between", value1, value2, "freeze");
            return (Criteria) this;
        }

        public Criteria andViolateIsNull() {
            addCriterion("violate is null");
            return (Criteria) this;
        }

        public Criteria andViolateIsNotNull() {
            addCriterion("violate is not null");
            return (Criteria) this;
        }

        public Criteria andViolateEqualTo(Integer value) {
            addCriterion("violate =", value, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateNotEqualTo(Integer value) {
            addCriterion("violate <>", value, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateGreaterThan(Integer value) {
            addCriterion("violate >", value, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateGreaterThanOrEqualTo(Integer value) {
            addCriterion("violate >=", value, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateLessThan(Integer value) {
            addCriterion("violate <", value, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateLessThanOrEqualTo(Integer value) {
            addCriterion("violate <=", value, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateIn(List<Integer> values) {
            addCriterion("violate in", values, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateNotIn(List<Integer> values) {
            addCriterion("violate not in", values, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateBetween(Integer value1, Integer value2) {
            addCriterion("violate between", value1, value2, "violate");
            return (Criteria) this;
        }

        public Criteria andViolateNotBetween(Integer value1, Integer value2) {
            addCriterion("violate not between", value1, value2, "violate");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeIsNull() {
            addCriterion("distribute_time is null");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeIsNotNull() {
            addCriterion("distribute_time is not null");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeEqualTo(Integer value) {
            addCriterion("distribute_time =", value, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeNotEqualTo(Integer value) {
            addCriterion("distribute_time <>", value, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeGreaterThan(Integer value) {
            addCriterion("distribute_time >", value, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("distribute_time >=", value, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeLessThan(Integer value) {
            addCriterion("distribute_time <", value, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeLessThanOrEqualTo(Integer value) {
            addCriterion("distribute_time <=", value, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeIn(List<Integer> values) {
            addCriterion("distribute_time in", values, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeNotIn(List<Integer> values) {
            addCriterion("distribute_time not in", values, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeBetween(Integer value1, Integer value2) {
            addCriterion("distribute_time between", value1, value2, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andDistributeTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("distribute_time not between", value1, value2, "distributeTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNull() {
            addCriterion("response_time is null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNotNull() {
            addCriterion("response_time is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeEqualTo(Integer value) {
            addCriterion("response_time =", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotEqualTo(Integer value) {
            addCriterion("response_time <>", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThan(Integer value) {
            addCriterion("response_time >", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("response_time >=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThan(Integer value) {
            addCriterion("response_time <", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("response_time <=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIn(List<Integer> values) {
            addCriterion("response_time in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotIn(List<Integer> values) {
            addCriterion("response_time not in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeBetween(Integer value1, Integer value2) {
            addCriterion("response_time between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("response_time not between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andAppAdressIsNull() {
            addCriterion("app_adress is null");
            return (Criteria) this;
        }

        public Criteria andAppAdressIsNotNull() {
            addCriterion("app_adress is not null");
            return (Criteria) this;
        }

        public Criteria andAppAdressEqualTo(String value) {
            addCriterion("app_adress =", value, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressNotEqualTo(String value) {
            addCriterion("app_adress <>", value, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressGreaterThan(String value) {
            addCriterion("app_adress >", value, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressGreaterThanOrEqualTo(String value) {
            addCriterion("app_adress >=", value, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressLessThan(String value) {
            addCriterion("app_adress <", value, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressLessThanOrEqualTo(String value) {
            addCriterion("app_adress <=", value, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressLike(String value) {
            addCriterion("app_adress like", value, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressNotLike(String value) {
            addCriterion("app_adress not like", value, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressIn(List<String> values) {
            addCriterion("app_adress in", values, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressNotIn(List<String> values) {
            addCriterion("app_adress not in", values, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressBetween(String value1, String value2) {
            addCriterion("app_adress between", value1, value2, "appAdress");
            return (Criteria) this;
        }

        public Criteria andAppAdressNotBetween(String value1, String value2) {
            addCriterion("app_adress not between", value1, value2, "appAdress");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawIsNull() {
            addCriterion("start_withdraw is null");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawIsNotNull() {
            addCriterion("start_withdraw is not null");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawEqualTo(String value) {
            addCriterion("start_withdraw =", value, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawNotEqualTo(String value) {
            addCriterion("start_withdraw <>", value, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawGreaterThan(String value) {
            addCriterion("start_withdraw >", value, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawGreaterThanOrEqualTo(String value) {
            addCriterion("start_withdraw >=", value, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawLessThan(String value) {
            addCriterion("start_withdraw <", value, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawLessThanOrEqualTo(String value) {
            addCriterion("start_withdraw <=", value, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawLike(String value) {
            addCriterion("start_withdraw like", value, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawNotLike(String value) {
            addCriterion("start_withdraw not like", value, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawIn(List<String> values) {
            addCriterion("start_withdraw in", values, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawNotIn(List<String> values) {
            addCriterion("start_withdraw not in", values, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawBetween(String value1, String value2) {
            addCriterion("start_withdraw between", value1, value2, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartWithdrawNotBetween(String value1, String value2) {
            addCriterion("start_withdraw not between", value1, value2, "startWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawIsNull() {
            addCriterion("end_withdraw is null");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawIsNotNull() {
            addCriterion("end_withdraw is not null");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawEqualTo(String value) {
            addCriterion("end_withdraw =", value, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawNotEqualTo(String value) {
            addCriterion("end_withdraw <>", value, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawGreaterThan(String value) {
            addCriterion("end_withdraw >", value, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawGreaterThanOrEqualTo(String value) {
            addCriterion("end_withdraw >=", value, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawLessThan(String value) {
            addCriterion("end_withdraw <", value, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawLessThanOrEqualTo(String value) {
            addCriterion("end_withdraw <=", value, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawLike(String value) {
            addCriterion("end_withdraw like", value, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawNotLike(String value) {
            addCriterion("end_withdraw not like", value, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawIn(List<String> values) {
            addCriterion("end_withdraw in", values, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawNotIn(List<String> values) {
            addCriterion("end_withdraw not in", values, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawBetween(String value1, String value2) {
            addCriterion("end_withdraw between", value1, value2, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andEndWithdrawNotBetween(String value1, String value2) {
            addCriterion("end_withdraw not between", value1, value2, "endWithdraw");
            return (Criteria) this;
        }

        public Criteria andStartDepositIsNull() {
            addCriterion("start_deposit is null");
            return (Criteria) this;
        }

        public Criteria andStartDepositIsNotNull() {
            addCriterion("start_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andStartDepositEqualTo(String value) {
            addCriterion("start_deposit =", value, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositNotEqualTo(String value) {
            addCriterion("start_deposit <>", value, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositGreaterThan(String value) {
            addCriterion("start_deposit >", value, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositGreaterThanOrEqualTo(String value) {
            addCriterion("start_deposit >=", value, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositLessThan(String value) {
            addCriterion("start_deposit <", value, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositLessThanOrEqualTo(String value) {
            addCriterion("start_deposit <=", value, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositLike(String value) {
            addCriterion("start_deposit like", value, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositNotLike(String value) {
            addCriterion("start_deposit not like", value, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositIn(List<String> values) {
            addCriterion("start_deposit in", values, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositNotIn(List<String> values) {
            addCriterion("start_deposit not in", values, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositBetween(String value1, String value2) {
            addCriterion("start_deposit between", value1, value2, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andStartDepositNotBetween(String value1, String value2) {
            addCriterion("start_deposit not between", value1, value2, "startDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositIsNull() {
            addCriterion("end_deposit is null");
            return (Criteria) this;
        }

        public Criteria andEndDepositIsNotNull() {
            addCriterion("end_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andEndDepositEqualTo(String value) {
            addCriterion("end_deposit =", value, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositNotEqualTo(String value) {
            addCriterion("end_deposit <>", value, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositGreaterThan(String value) {
            addCriterion("end_deposit >", value, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositGreaterThanOrEqualTo(String value) {
            addCriterion("end_deposit >=", value, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositLessThan(String value) {
            addCriterion("end_deposit <", value, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositLessThanOrEqualTo(String value) {
            addCriterion("end_deposit <=", value, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositLike(String value) {
            addCriterion("end_deposit like", value, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositNotLike(String value) {
            addCriterion("end_deposit not like", value, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositIn(List<String> values) {
            addCriterion("end_deposit in", values, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositNotIn(List<String> values) {
            addCriterion("end_deposit not in", values, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositBetween(String value1, String value2) {
            addCriterion("end_deposit between", value1, value2, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andEndDepositNotBetween(String value1, String value2) {
            addCriterion("end_deposit not between", value1, value2, "endDeposit");
            return (Criteria) this;
        }

        public Criteria andStartConveyIsNull() {
            addCriterion("start_convey is null");
            return (Criteria) this;
        }

        public Criteria andStartConveyIsNotNull() {
            addCriterion("start_convey is not null");
            return (Criteria) this;
        }

        public Criteria andStartConveyEqualTo(String value) {
            addCriterion("start_convey =", value, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyNotEqualTo(String value) {
            addCriterion("start_convey <>", value, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyGreaterThan(String value) {
            addCriterion("start_convey >", value, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyGreaterThanOrEqualTo(String value) {
            addCriterion("start_convey >=", value, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyLessThan(String value) {
            addCriterion("start_convey <", value, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyLessThanOrEqualTo(String value) {
            addCriterion("start_convey <=", value, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyLike(String value) {
            addCriterion("start_convey like", value, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyNotLike(String value) {
            addCriterion("start_convey not like", value, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyIn(List<String> values) {
            addCriterion("start_convey in", values, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyNotIn(List<String> values) {
            addCriterion("start_convey not in", values, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyBetween(String value1, String value2) {
            addCriterion("start_convey between", value1, value2, "startConvey");
            return (Criteria) this;
        }

        public Criteria andStartConveyNotBetween(String value1, String value2) {
            addCriterion("start_convey not between", value1, value2, "startConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyIsNull() {
            addCriterion("end_convey is null");
            return (Criteria) this;
        }

        public Criteria andEndConveyIsNotNull() {
            addCriterion("end_convey is not null");
            return (Criteria) this;
        }

        public Criteria andEndConveyEqualTo(String value) {
            addCriterion("end_convey =", value, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyNotEqualTo(String value) {
            addCriterion("end_convey <>", value, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyGreaterThan(String value) {
            addCriterion("end_convey >", value, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyGreaterThanOrEqualTo(String value) {
            addCriterion("end_convey >=", value, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyLessThan(String value) {
            addCriterion("end_convey <", value, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyLessThanOrEqualTo(String value) {
            addCriterion("end_convey <=", value, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyLike(String value) {
            addCriterion("end_convey like", value, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyNotLike(String value) {
            addCriterion("end_convey not like", value, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyIn(List<String> values) {
            addCriterion("end_convey in", values, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyNotIn(List<String> values) {
            addCriterion("end_convey not in", values, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyBetween(String value1, String value2) {
            addCriterion("end_convey between", value1, value2, "endConvey");
            return (Criteria) this;
        }

        public Criteria andEndConveyNotBetween(String value1, String value2) {
            addCriterion("end_convey not between", value1, value2, "endConvey");
            return (Criteria) this;
        }

        public Criteria andShopStatusIsNull() {
            addCriterion("shop_status is null");
            return (Criteria) this;
        }

        public Criteria andShopStatusIsNotNull() {
            addCriterion("shop_status is not null");
            return (Criteria) this;
        }

        public Criteria andShopStatusEqualTo(Integer value) {
            addCriterion("shop_status =", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotEqualTo(Integer value) {
            addCriterion("shop_status <>", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusGreaterThan(Integer value) {
            addCriterion("shop_status >", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_status >=", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusLessThan(Integer value) {
            addCriterion("shop_status <", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusLessThanOrEqualTo(Integer value) {
            addCriterion("shop_status <=", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusIn(List<Integer> values) {
            addCriterion("shop_status in", values, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotIn(List<Integer> values) {
            addCriterion("shop_status not in", values, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusBetween(Integer value1, Integer value2) {
            addCriterion("shop_status between", value1, value2, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_status not between", value1, value2, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andRemankIsNull() {
            addCriterion("remank is null");
            return (Criteria) this;
        }

        public Criteria andRemankIsNotNull() {
            addCriterion("remank is not null");
            return (Criteria) this;
        }

        public Criteria andRemankEqualTo(String value) {
            addCriterion("remank =", value, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankNotEqualTo(String value) {
            addCriterion("remank <>", value, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankGreaterThan(String value) {
            addCriterion("remank >", value, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankGreaterThanOrEqualTo(String value) {
            addCriterion("remank >=", value, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankLessThan(String value) {
            addCriterion("remank <", value, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankLessThanOrEqualTo(String value) {
            addCriterion("remank <=", value, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankLike(String value) {
            addCriterion("remank like", value, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankNotLike(String value) {
            addCriterion("remank not like", value, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankIn(List<String> values) {
            addCriterion("remank in", values, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankNotIn(List<String> values) {
            addCriterion("remank not in", values, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankBetween(String value1, String value2) {
            addCriterion("remank between", value1, value2, "remank");
            return (Criteria) this;
        }

        public Criteria andRemankNotBetween(String value1, String value2) {
            addCriterion("remank not between", value1, value2, "remank");
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