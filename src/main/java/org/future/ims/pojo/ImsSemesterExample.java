package org.future.ims.pojo;

import java.util.ArrayList;
import java.util.List;

public class ImsSemesterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsSemesterExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    /**
     * null
     * 
     * @author wcyong
     * 
     * @date 2017-11-03
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andSemesterIdIsNull() {
            addCriterion("semester_id is null");
            return (Criteria) this;
        }

        public Criteria andSemesterIdIsNotNull() {
            addCriterion("semester_id is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterIdEqualTo(Integer value) {
            addCriterion("semester_id =", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdNotEqualTo(Integer value) {
            addCriterion("semester_id <>", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdGreaterThan(Integer value) {
            addCriterion("semester_id >", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("semester_id >=", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdLessThan(Integer value) {
            addCriterion("semester_id <", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdLessThanOrEqualTo(Integer value) {
            addCriterion("semester_id <=", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdIn(List<Integer> values) {
            addCriterion("semester_id in", values, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdNotIn(List<Integer> values) {
            addCriterion("semester_id not in", values, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdBetween(Integer value1, Integer value2) {
            addCriterion("semester_id between", value1, value2, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("semester_id not between", value1, value2, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterNameIsNull() {
            addCriterion("semester_name is null");
            return (Criteria) this;
        }

        public Criteria andSemesterNameIsNotNull() {
            addCriterion("semester_name is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterNameEqualTo(String value) {
            addCriterion("semester_name =", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameNotEqualTo(String value) {
            addCriterion("semester_name <>", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameGreaterThan(String value) {
            addCriterion("semester_name >", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameGreaterThanOrEqualTo(String value) {
            addCriterion("semester_name >=", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameLessThan(String value) {
            addCriterion("semester_name <", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameLessThanOrEqualTo(String value) {
            addCriterion("semester_name <=", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameLike(String value) {
            addCriterion("semester_name like", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameNotLike(String value) {
            addCriterion("semester_name not like", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameIn(List<String> values) {
            addCriterion("semester_name in", values, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameNotIn(List<String> values) {
            addCriterion("semester_name not in", values, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameBetween(String value1, String value2) {
            addCriterion("semester_name between", value1, value2, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameNotBetween(String value1, String value2) {
            addCriterion("semester_name not between", value1, value2, "semesterName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * null
     * 
     * @author wcyong
     * 
     * @date 2017-11-03
     */
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