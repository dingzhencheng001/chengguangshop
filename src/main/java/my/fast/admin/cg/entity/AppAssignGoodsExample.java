package my.fast.admin.cg.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppAssignGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppAssignGoodsExample() {
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

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIsNull() {
            addCriterion("goods_info is null");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIsNotNull() {
            addCriterion("goods_info is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoEqualTo(String value) {
            addCriterion("goods_info =", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotEqualTo(String value) {
            addCriterion("goods_info <>", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoGreaterThan(String value) {
            addCriterion("goods_info >", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoGreaterThanOrEqualTo(String value) {
            addCriterion("goods_info >=", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLessThan(String value) {
            addCriterion("goods_info <", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLessThanOrEqualTo(String value) {
            addCriterion("goods_info <=", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLike(String value) {
            addCriterion("goods_info like", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotLike(String value) {
            addCriterion("goods_info not like", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIn(List<String> values) {
            addCriterion("goods_info in", values, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotIn(List<String> values) {
            addCriterion("goods_info not in", values, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoBetween(String value1, String value2) {
            addCriterion("goods_info between", value1, value2, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotBetween(String value1, String value2) {
            addCriterion("goods_info not between", value1, value2, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIsNull() {
            addCriterion("goods_pic is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIsNotNull() {
            addCriterion("goods_pic is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPicEqualTo(String value) {
            addCriterion("goods_pic =", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotEqualTo(String value) {
            addCriterion("goods_pic <>", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicGreaterThan(String value) {
            addCriterion("goods_pic >", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicGreaterThanOrEqualTo(String value) {
            addCriterion("goods_pic >=", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLessThan(String value) {
            addCriterion("goods_pic <", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLessThanOrEqualTo(String value) {
            addCriterion("goods_pic <=", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLike(String value) {
            addCriterion("goods_pic like", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotLike(String value) {
            addCriterion("goods_pic not like", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIn(List<String> values) {
            addCriterion("goods_pic in", values, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotIn(List<String> values) {
            addCriterion("goods_pic not in", values, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicBetween(String value1, String value2) {
            addCriterion("goods_pic between", value1, value2, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotBetween(String value1, String value2) {
            addCriterion("goods_pic not between", value1, value2, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeIsNull() {
            addCriterion("goods_add_time is null");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeIsNotNull() {
            addCriterion("goods_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeEqualTo(Date value) {
            addCriterion("goods_add_time =", value, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeNotEqualTo(Date value) {
            addCriterion("goods_add_time <>", value, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeGreaterThan(Date value) {
            addCriterion("goods_add_time >", value, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_add_time >=", value, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeLessThan(Date value) {
            addCriterion("goods_add_time <", value, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("goods_add_time <=", value, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeIn(List<Date> values) {
            addCriterion("goods_add_time in", values, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeNotIn(List<Date> values) {
            addCriterion("goods_add_time not in", values, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeBetween(Date value1, Date value2) {
            addCriterion("goods_add_time between", value1, value2, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andGoodsAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("goods_add_time not between", value1, value2, "goodsAddTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Long> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Long> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
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

        public Criteria andGoodsSortIdIsNull() {
            addCriterion("goods_sort_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdIsNotNull() {
            addCriterion("goods_sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdEqualTo(Long value) {
            addCriterion("goods_sort_id =", value, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdNotEqualTo(Long value) {
            addCriterion("goods_sort_id <>", value, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdGreaterThan(Long value) {
            addCriterion("goods_sort_id >", value, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_sort_id >=", value, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdLessThan(Long value) {
            addCriterion("goods_sort_id <", value, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_sort_id <=", value, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdIn(List<Long> values) {
            addCriterion("goods_sort_id in", values, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdNotIn(List<Long> values) {
            addCriterion("goods_sort_id not in", values, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdBetween(Long value1, Long value2) {
            addCriterion("goods_sort_id between", value1, value2, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andGoodsSortIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_sort_id not between", value1, value2, "goodsSortId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIsNull() {
            addCriterion("task_group is null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIsNotNull() {
            addCriterion("task_group is not null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupEqualTo(Integer value) {
            addCriterion("task_group =", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotEqualTo(Integer value) {
            addCriterion("task_group <>", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupGreaterThan(Integer value) {
            addCriterion("task_group >", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_group >=", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupLessThan(Integer value) {
            addCriterion("task_group <", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupLessThanOrEqualTo(Integer value) {
            addCriterion("task_group <=", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIn(List<Integer> values) {
            addCriterion("task_group in", values, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotIn(List<Integer> values) {
            addCriterion("task_group not in", values, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupBetween(Integer value1, Integer value2) {
            addCriterion("task_group between", value1, value2, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("task_group not between", value1, value2, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andHinderIsNull() {
            addCriterion("hinder is null");
            return (Criteria) this;
        }

        public Criteria andHinderIsNotNull() {
            addCriterion("hinder is not null");
            return (Criteria) this;
        }

        public Criteria andHinderEqualTo(Integer value) {
            addCriterion("hinder =", value, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderNotEqualTo(Integer value) {
            addCriterion("hinder <>", value, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderGreaterThan(Integer value) {
            addCriterion("hinder >", value, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderGreaterThanOrEqualTo(Integer value) {
            addCriterion("hinder >=", value, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderLessThan(Integer value) {
            addCriterion("hinder <", value, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderLessThanOrEqualTo(Integer value) {
            addCriterion("hinder <=", value, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderIn(List<Integer> values) {
            addCriterion("hinder in", values, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderNotIn(List<Integer> values) {
            addCriterion("hinder not in", values, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderBetween(Integer value1, Integer value2) {
            addCriterion("hinder between", value1, value2, "hinder");
            return (Criteria) this;
        }

        public Criteria andHinderNotBetween(Integer value1, Integer value2) {
            addCriterion("hinder not between", value1, value2, "hinder");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityIsNull() {
            addCriterion("order_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityIsNotNull() {
            addCriterion("order_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityEqualTo(Integer value) {
            addCriterion("order_quantity =", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNotEqualTo(Integer value) {
            addCriterion("order_quantity <>", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityGreaterThan(Integer value) {
            addCriterion("order_quantity >", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_quantity >=", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityLessThan(Integer value) {
            addCriterion("order_quantity <", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("order_quantity <=", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityIn(List<Integer> values) {
            addCriterion("order_quantity in", values, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNotIn(List<Integer> values) {
            addCriterion("order_quantity not in", values, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityBetween(Integer value1, Integer value2) {
            addCriterion("order_quantity between", value1, value2, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("order_quantity not between", value1, value2, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andIsConsumedIsNull() {
            addCriterion("is_consumed is null");
            return (Criteria) this;
        }

        public Criteria andIsConsumedIsNotNull() {
            addCriterion("is_consumed is not null");
            return (Criteria) this;
        }

        public Criteria andIsConsumedEqualTo(Integer value) {
            addCriterion("is_consumed =", value, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedNotEqualTo(Integer value) {
            addCriterion("is_consumed <>", value, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedGreaterThan(Integer value) {
            addCriterion("is_consumed >", value, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_consumed >=", value, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedLessThan(Integer value) {
            addCriterion("is_consumed <", value, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedLessThanOrEqualTo(Integer value) {
            addCriterion("is_consumed <=", value, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedIn(List<Integer> values) {
            addCriterion("is_consumed in", values, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedNotIn(List<Integer> values) {
            addCriterion("is_consumed not in", values, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedBetween(Integer value1, Integer value2) {
            addCriterion("is_consumed between", value1, value2, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andIsConsumedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_consumed not between", value1, value2, "isConsumed");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andWhichGroupIsNull() {
            addCriterion("which_group is null");
            return (Criteria) this;
        }

        public Criteria andWhichGroupIsNotNull() {
            addCriterion("which_group is not null");
            return (Criteria) this;
        }

        public Criteria andWhichGroupEqualTo(Integer value) {
            addCriterion("which_group =", value, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupNotEqualTo(Integer value) {
            addCriterion("which_group <>", value, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupGreaterThan(Integer value) {
            addCriterion("which_group >", value, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("which_group >=", value, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupLessThan(Integer value) {
            addCriterion("which_group <", value, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupLessThanOrEqualTo(Integer value) {
            addCriterion("which_group <=", value, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupIn(List<Integer> values) {
            addCriterion("which_group in", values, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupNotIn(List<Integer> values) {
            addCriterion("which_group not in", values, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupBetween(Integer value1, Integer value2) {
            addCriterion("which_group between", value1, value2, "whichGroup");
            return (Criteria) this;
        }

        public Criteria andWhichGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("which_group not between", value1, value2, "whichGroup");
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