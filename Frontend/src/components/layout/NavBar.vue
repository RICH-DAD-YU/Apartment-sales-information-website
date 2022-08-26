<template>
  <!-- ====== Navbar Section Start -->
  <div
    class="ud-header absolute sticky top-0 left-0 z-40 flex w-full items-center"
    style="background-color: #786d64"
  >
    <div class="container">
      <div class="relative -mx-4 flex items-center justify-between">
        <div class="w-60 max-w-full px-4">
          <router-link to="/" class="navbar-logo block w-full py-5">
            <img
              src="../../../public/assets/images/logo/logo.png"
              alt="logo"
              class="header-logo w-full"
            />
          </router-link>
        </div>
        <div class="flex w-full items-center justify-between px-4">
          <div>
            <nav id="navbarCollapse" class="">
              <ul class="blcok lg:flex">
                <li class="group relative">
                  <router-link
                    to="/"
                    class="
                      ud-menu-scroll
                      mx-10
                      flex
                      py-2
                      text-2xl text-base
                      font-bold
                      text-white
                      group-hover:text-primary
                      lg:mr-0
                      lg:inline-flex
                      lg:py-6
                      lg:px-0
                      lg:group-hover:text-white
                      lg:group-hover:opacity-70
                    "
                  >
                    Home
                  </router-link>
                </li>
                <li class="group relative">
                  <router-link
                    to="/apt"
                    class="
                      ud-menu-scroll
                      mx-10
                      flex
                      py-2
                      text-2xl text-base
                      font-bold
                      text-white
                      group-hover:text-primary
                      lg:mr-0
                      lg:ml-7
                      lg:inline-flex
                      lg:py-6
                      lg:px-0
                      lg:group-hover:text-white
                      lg:group-hover:opacity-70
                      xl:ml-12
                    "
                  >
                    Apartment
                  </router-link>
                </li>
                <!-- <li class="group relative">
                  <router-link
                    to="/aptTmp"
                    class="
                      ud-menu-scroll
                      mx-8
                      flex
                      py-2
                      text-xl text-base
                      font-bold
                      text-white
                      group-hover:text-primary
                      lg:mr-0
                      lg:ml-7
                      lg:inline-flex
                      lg:py-6
                      lg:px-0
                      lg:group-hover:text-white
                      lg:group-hover:opacity-70
                      xl:ml-12
                    "
                  >
                    Apartment Tmp
                  </router-link>
                </li> -->
                <li class="group relative">
                  <router-link
                    to="/board"
                    class="
                      ud-menu-scroll
                      mx-10
                      flex
                      py-2
                      text-2xl text-base
                      font-bold
                      text-white
                      group-hover:text-primary
                      lg:mr-0
                      lg:ml-7
                      lg:inline-flex
                      lg:py-6
                      lg:px-0
                      lg:group-hover:text-white
                      lg:group-hover:opacity-70
                      xl:ml-12
                    "
                  >
                    Board
                  </router-link>
                </li>
                <li class="group relative">
                  <router-link
                    to="/team"
                    class="
                      ud-menu-scroll
                      mx-10
                      flex
                      py-2
                      text-2xl text-base
                      font-bold
                      text-white
                      group-hover:text-primary
                      lg:mr-0
                      lg:ml-7
                      lg:inline-flex
                      lg:py-6
                      lg:px-0
                      lg:group-hover:text-white
                      lg:group-hover:opacity-70
                      xl:ml-12
                    "
                  >
                    Team
                  </router-link>
                </li>
              </ul>
            </nav>
          </div>
          <div class="hidden justify-end pr-16 sm:flex lg:pr-0">
            <a
              class="
                loginBtn
                py-3
                px-7
                text-2xl text-base
                font-bold font-medium
                text-white
                hover:opacity-70
              "
              v-if="$store.state.login.isLogin"
              @click.self.prevent="logout()"
              style="cursor: pointer"
            >
              Logout
            </a>
            <router-link
              to="/user"
              v-show="$store.state.login.isLogin"
              class="
                loginBtn
                py-3
                px-7
                text-2xl text-base
                font-bold font-medium
                text-white
                hover:opacity-70
              "
            >
              My Page
            </router-link>
            <router-link
              to="/login"
              v-show="!$store.state.login.isLogin"
              class="
                loginBtn
                py-3
                px-7
                text-2xl text-base
                font-bold font-medium
                text-white
                hover:opacity-70
              "
            >
              Log In
            </router-link>

            <router-link
              to="/register"
              v-show="!$store.state.login.isLogin"
              class="
                signUpBtn
                rounded-lg
                bg-white bg-opacity-20
                py-3
                px-6
                text-2xl text-base
                font-bold font-medium
                duration-300
                ease-in-out
                hover:bg-opacity-100 hover:text-dark
              "
              style="color: #786d64"
            >
              Sign Up
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- ====== Navbar Section End -->
</template>

<script>
export default {
  methods: {
    logout() {
      this.$alertify.confirm("로그아웃 하시겠습니까?", () => {
        this.$store.commit("SET_LOGIN", {
          isLogin: false,
          userName: "",
          userSeq: 0,
          userEmail: "",
          userPassword: "",
        });

        this.$alertify.alert("로그아웃", "로그아웃 성공");

        this.$router.push("/");
      });
    },
  },
};
</script>

<style></style>
