package org.future.ims.pojo;

import java.util.ArrayList;
import java.util.List;

public class SortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SortExample() {
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
     * @date 2017-11-12
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

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andAllscoreIsNull() {
            addCriterion("allscore is null");
            return (Criteria) this;
        }

        public Criteria andAllscoreIsNotNull() {
            addCriterion("allscore is not null");
            return (Criteria) this;
        }

        public Criteria andAllscoreEqualTo(Float value) {
            addCriterion("allscore =", value, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreNotEqualTo(Float value) {
            addCriterion("allscore <>", value, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreGreaterThan(Float value) {
            addCriterion("allscore >", value, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreGreaterThanOrEqualTo(Float value) {
            addCriterion("allscore >=", value, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreLessThan(Float value) {
            addCriterion("allscore <", value, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreLessThanOrEqualTo(Float value) {
            addCriterion("allscore <=", value, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreIn(List<Float> values) {
            addCriterion("allscore in", values, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreNotIn(List<Float> values) {
            addCriterion("allscore not in", values, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreBetween(Float value1, Float value2) {
            addCriterion("allscore between", value1, value2, "allscore");
            return (Criteria) this;
        }

        public Criteria andAllscoreNotBetween(Float value1, Float value2) {
            addCriterion("allscore not between", value1, value2, "allscore");
            return (Criteria) this;
        }

        public Criteria andGradesIsNull() {
            addCriterion("grades is null");
            return (Criteria) this;
        }

        public Criteria andGradesIsNotNull() {
            addCriterion("grades is not null");
            return (Criteria) this;
        }

        public Criteria andGradesEqualTo(String value) {
            addCriterion("grades =", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesNotEqualTo(String value) {
            addCriterion("grades <>", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesGreaterThan(String value) {
            addCriterion("grades >", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesGreaterThanOrEqualTo(String value) {
            addCriterion("grades >=", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesLessThan(String value) {
            addCriterion("grades <", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesLessThanOrEqualTo(String value) {
            addCriterion("grades <=", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesLike(String value) {
            addCriterion("grades like", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesNotLike(String value) {
            addCriterion("grades not like", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesIn(List<String> values) {
            addCriterion("grades in", values, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesNotIn(List<String> values) {
            addCriterion("grades not in", values, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesBetween(String value1, String value2) {
            addCriterion("grades between", value1, value2, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesNotBetween(String value1, String value2) {
            addCriterion("grades not between", value1, value2, "grades");
            return (Criteria) this;
        }

        public Criteria andIntSemesterIsNull() {
            addCriterion("int_semester is null");
            return (Criteria) this;
        }

        public Criteria andIntSemesterIsNotNull() {
            addCriterion("int_semester is not null");
            return (Criteria) this;
        }

        public Criteria andIntSemesterEqualTo(String value) {
            addCriterion("int_semester =", value, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterNotEqualTo(String value) {
            addCriterion("int_semester <>", value, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterGreaterThan(String value) {
            addCriterion("int_semester >", value, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterGreaterThanOrEqualTo(String value) {
            addCriterion("int_semester >=", value, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterLessThan(String value) {
            addCriterion("int_semester <", value, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterLessThanOrEqualTo(String value) {
            addCriterion("int_semester <=", value, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterLike(String value) {
            addCriterion("int_semester like", value, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterNotLike(String value) {
            addCriterion("int_semester not like", value, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterIn(List<String> values) {
            addCriterion("int_semester in", values, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterNotIn(List<String> values) {
            addCriterion("int_semester not in", values, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterBetween(String value1, String value2) {
            addCriterion("int_semester between", value1, value2, "intSemester");
            return (Criteria) this;
        }

        public Criteria andIntSemesterNotBetween(String value1, String value2) {
            addCriterion("int_semester not between", value1, value2, "intSemester");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
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
     * @date 2017-11-12
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