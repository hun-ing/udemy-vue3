export default {
    getCoaches(state) {
        return state.coaches;
    },
    hasCoaches(state) {
        return state.coaches && state.coaches.length > 0;
    },
    findCoachById(state) {
        return (coachId) => state.coaches.find(coach => coach.id === coachId);
    },
    getFullNameById(state) {
        return (coachId) => {
            const findCoach = state.coaches.find(coach => coach.id === coachId);
            return findCoach && `${findCoach.firstName} ${findCoach.lastName}`;
        }
    },
    getCoachesByAreas(state) {
        return (areas) => {
            return state.coaches.filter(coach => {
                for (const [key, value] of Object.entries(areas)) {
                    if (value && coach.areas.includes(key)) {
                        return true;
                    }
                }
            });
        }
    },
}