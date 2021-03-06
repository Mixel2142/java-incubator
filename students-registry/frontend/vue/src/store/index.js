import Vue from 'vue'
import Vuex from 'vuex'
import auth from './modules/auth'
import users from './modules/users'
import register from './modules/register'
import tasks from './modules/tasks'
import projects from './modules/projects'
import shared from './modules/shared'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        shared,
        auth,
        users,
        register,
        tasks,
        projects
    },
    state: {
        title: 'Hello from store'
    },
    getters: {
        title (state) {
            return state.title + '!!!'
        }
    }
})
