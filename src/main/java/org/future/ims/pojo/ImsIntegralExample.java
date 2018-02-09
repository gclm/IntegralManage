package org.future.ims.pojo;

import java.util.ArrayList;
import java.util.List;

public class ImsIntegralExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImsIntegralExample() {
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
     * @date 2017-11-10
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

        public Criteria andIntegralIdIsNull() {
            addCriterion("integral_id is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIdIsNotNull() {
            addCriterion("integral_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralIdEqualTo(Integer value) {
            addCriterion("integral_id =", value, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdNotEqualTo(Integer value) {
            addCriterion("integral_id <>", value, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdGreaterThan(Integer value) {
            addCriterion("integral_id >", value, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_id >=", value, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdLessThan(Integer value) {
            addCriterion("integral_id <", value, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdLessThanOrEqualTo(Integer value) {
            addCriterion("integral_id <=", value, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdIn(List<Integer> values) {
            addCriterion("integral_id in", values, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdNotIn(List<Integer> values) {
            addCriterion("integral_id not in", values, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdBetween(Integer value1, Integer value2) {
            addCriterion("integral_id between", value1, value2, "integralId");
            return (Criteria) this;
        }

        public Criteria andIntegralIdNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_id not between", value1, value2, "integralId");
            return (Criteria) this;
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Float value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Float value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Float value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Float value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Float value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Float> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Float> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Float value1, Float value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Float value1, Float value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andClubroomIsNull() {
            addCriterion("clubroom is null");
            return (Criteria) this;
        }

        public Criteria andClubroomIsNotNull() {
            addCriterion("clubroom is not null");
            return (Criteria) this;
        }

        public Criteria andClubroomEqualTo(String value) {
            addCriterion("clubroom =", value, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomNotEqualTo(String value) {
            addCriterion("clubroom <>", value, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomGreaterThan(String value) {
            addCriterion("clubroom >", value, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomGreaterThanOrEqualTo(String value) {
            addCriterion("clubroom >=", value, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomLessThan(String value) {
            addCriterion("clubroom <", value, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomLessThanOrEqualTo(String value) {
            addCriterion("clubroom <=", value, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomLike(String value) {
            addCriterion("clubroom like", value, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomNotLike(String value) {
            addCriterion("clubroom not like", value, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomIn(List<String> values) {
            addCriterion("clubroom in", values, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomNotIn(List<String> values) {
            addCriterion("clubroom not in", values, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomBetween(String value1, String value2) {
            addCriterion("clubroom between", value1, value2, "clubroom");
            return (Criteria) this;
        }

        public Criteria andClubroomNotBetween(String value1, String value2) {
            addCriterion("clubroom not between", value1, value2, "clubroom");
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

        public Criteria andCreatimeIsNull() {
            addCriterion("creatime is null");
            return (Criteria) this;
        }

        public Criteria andCreatimeIsNotNull() {
            addCriterion("creatime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatimeEqualTo(String value) {
            addCriterion("creatime =", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeNotEqualTo(String value) {
            addCriterion("creatime <>", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeGreaterThan(String value) {
            addCriterion("creatime >", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeGreaterThanOrEqualTo(String value) {
            addCriterion("creatime >=", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeLessThan(String value) {
            addCriterion("creatime <", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeLessThanOrEqualTo(String value) {
            addCriterion("creatime <=", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeLike(String value) {
            addCriterion("creatime like", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeNotLike(String value) {
            addCriterion("creatime not like", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeIn(List<String> values) {
            addCriterion("creatime in", values, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeNotIn(List<String> values) {
            addCriterion("creatime not in", values, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeBetween(String value1, String value2) {
            addCriterion("creatime between", value1, value2, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeNotBetween(String value1, String value2) {
            addCriterion("creatime not between", value1, value2, "creatime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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
     * @date 2017-11-10
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