lazy val commonSettings = Seq(
  version in ThisBuild := "0.1.6-SNAPSHOT",
  organization in ThisBuild := "com.eed3si9n"
)

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    sbtPlugin := true,
    name := "sbt-doge",
    description := "sbt plugin to aggregate across crossScalaVerions for muilti-project builds",
    licenses := Seq("MIT License" -> url("http://opensource.org/licenses/MIT")),
    scalacOptions := Seq("-deprecation", "-unchecked")
  )

publishTo := {
    val corporateRepo = "http://toucan.simplesys.lan/"
    if (isSnapshot.value)
        Some("snapshots" at corporateRepo + "artifactory/libs-snapshot-local")
    else
        Some("releases" at corporateRepo + "artifactory/libs-release-local")
}
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
