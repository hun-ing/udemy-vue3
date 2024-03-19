import {createRouter, createWebHistory} from "vue-router";
import {useAuthStore} from "@/stores/auth/index.js";
import CoachesList from "@/pages/coaches/CoachesList.vue";
import NotFound from "@/pages/NotFound.vue";
import TheDefaultLayout from '@/components/layouts/DefaultLayout.vue';
import TheDashboardLayout from '@/components/layouts/BlankLayout.vue';
// import CoachDetail from "@/pages/coaches/CoachDetail.vue";
// import ContactCoach from "@/pages/requests/ContactCoach.vue";
// import CoachesRegistration from "@/pages/coaches/CoachesRegistration.vue";
// import RequestsReceived from "@/pages/requests/RequestsReceived.vue";
// import UserAuth from '@/pages/auth/UserAuth.vue';

const CoachDetail = () => import('@/pages/coaches/CoachDetail.vue');
const CoachesRegistration = () => import('@/pages/coaches/CoachesRegistration.vue');
const ContactCoach = () => import('@/pages/requests/ContactCoach.vue');
const RequestsReceived = () => import('@/pages/requests/RequestsReceived.vue');
const UserAuth = () => import('@/pages/auth/UserAuth.vue');

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', redirect: '/coaches',},
        {path: '/coaches', component: CoachesList, meta: {layout: TheDefaultLayout,}},
        {
            path: '/coaches/:id',
            component: CoachDetail,
            props: true,
            meta: {layout: 'TheDefaultLayout',},
            children: [{path: 'contact', component: ContactCoach, meta: {layout: TheDefaultLayout,},}]
        },
        {path: '/register', component: CoachesRegistration, meta: {layout: TheDefaultLayout,requiresAuth: true}},
        {path: '/requests', component: RequestsReceived, meta: {layout: TheDefaultLayout,requiresAuth: true}},
        {path: '/auth', component: UserAuth, meta: {layout: TheDashboardLayout, requiresUnauth: true}},
        {path: '/:notFound(.*)', component: NotFound, meta: {layout: TheDashboardLayout,}},
    ],
});

router.beforeEach((to, from, next) => {
    const authStore = useAuthStore();
    console.log('authStore = ', authStore.isAuthenticated);
    console.log('to.meta = ', to.meta);
    console.log('from.meta = ', from.meta);
    if (to.meta.requiresAuth && !authStore.isAuthenticated) {
        next('/auth')
    } else if (to.meta.requiresUnauth && authStore.isAuthenticated) {
        next('/coaches')
    } else {
        next()
    }
})
export default router;