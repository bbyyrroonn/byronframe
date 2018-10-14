<template>
    <div class="login">
        <div class="login-container animated fadeInDown">
            <div class="loginbox bg-white">
                <div class="loginbox-title">SIGN IN</div>
                <div class="loginbox-social">
                    <div class="social-title ">Connect with Your Social Accounts</div>
                    <!-- <div class="social-buttons">
                        <a href="" class="button-facebook">
                            <i class="social-icon fa fa-facebook"></i>
                        </a>
                        <a href="" class="button-twitter">
                            <i class="social-icon fa fa-twitter"></i>
                        </a>
                        <a href="" class="button-google">
                            <i class="social-icon fa fa-google-plus"></i>
                        </a>
                    </div> -->
                </div>
                <div class="loginbox-or">
                    <div class="or-line"></div>
                    <div class="or">OR</div>
                </div>
                <div class="loginbox-textbox">
                    <input type="text" class="form-control" name="email" placeholder="Email" v-model="email" v-validate="'required|email'"/>
                    <small class="help-block">{{ errors.first('email') }}</small>
                </div>
                <div class="loginbox-textbox">
                    <input type="text" class="form-control" placeholder="Password" v-model="password"/>
                </div>
                <div class="loginbox-forgot">
                    <a href="">Forgot Password?</a>
                </div>
                <div class="loginbox-submit">
                    <input type="button" class="btn btn-primary btn-block" value="Login" @click="logon()">
                </div>
                <div class="loginbox-signup">
                    <a href="register.html">Sign Up With Email</a>
                </div>
            </div>
            <div class="logobox">
            </div>
        </div>
    </div>
</template>

<script>
import Vue from 'vue';
import VeeValidate from 'vee-validate';

Vue.use(VeeValidate);


export default {
    name: 'login',
    data () {
        return {
            email: 'bbyyrroonn@163.com',
            password: '11223344'
        }
    },

    methods: {
        logon() {
            alert('haha');
        }
    }

}
</script>

<style scoped>
</style>