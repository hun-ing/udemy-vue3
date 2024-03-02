import { useGlobalStore } from '@/stores/index.js'

export default {
    getCoaches(state) {
        return state.coaches;
    },
    hasCoaches(state) {
        return state.coaches && state.coaches.length > 0;
    },
    findCoachById(state) {
        console.log(state.coaches);
        return (coachId) => state.coaches.find(coach => coach.id === Number(coachId));
    },
    getFullNameById(state) {
        return (coachId) => {
            const findCoach = state.coaches.find(coach => coach.id === Number(coachId));
            return findCoach && `${findCoach.firstName} ${findCoach.lastName}`;
        }
    },
    getCoachesByAreas(state) {
        return (areas) => {
            return state.coaches.filter(coach => {
                const coachAreas = coach.areas.map(area => area.area);
                for (const [key, value] of Object.entries(areas)) {
                    if (value && coachAreas.includes(key)) {
                        return true;
                    }
                }
            });
        }
    },
    isCoach(state) {
        console.log('isCoach...')
        const globalStore = useGlobalStore()
        const coaches = state.getCoaches
        const userId = globalStore.userId
        return coaches.some(coach => coach.id === Number(userId))
    }
}