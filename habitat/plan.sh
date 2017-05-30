pkg_name=hello-dropwizard
pkg_description="Hello Dropwizard demo application."
pkg_origin=brentm5
pkg_version="0.1.0"
pkg_license=('Apache-2.0')
pkg_upstream_url="https://github.com/brentm5/hello-dropwizard"
pkg_build_deps=(core/jdk8 core/maven)
pkg_deps=(core/jdk8)

pkg_exports=(
  [http]=server.http
  [admin]=server.admin
)

pkg_exposes=(http admin)

do_build() {
  pushd "${PLAN_CONTEXT}"/.. > /dev/null
  mvn install
  popd > /dev/null
}

do_install() {
  mkdir -p "${pkg_prefix}/bin"
  cp "${PLAN_CONTEXT}"/../target/helloworld-1.0-SNAPSHOT.jar "${pkg_prefix}/service.jar"
  # cp "${PLAN_CONTEXT}"/../configs/* "${pkg_prefix}"
}
