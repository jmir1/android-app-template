# android-app-template

![Build](https://github.com/jmir1/android-app-template/workflows/Pre%20Merge%20Checks/badge.svg)

This is your new Kotlin Android Project! Happy hacking!

## License

    Copyright (C) 2023 jmir1

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

## Template ToDo list 👣

- [x] Create a new template project.
- [x] Choose a [LICENSE](https://github.com/jmir1/android-app-template/community/license/new?branch=main).
- [ ] Code some cool apps and libraries 🚀.

## Features 🎨

- **100% Kotlin-only template**.
- 4 Sample modules (Android app, Android library, Kotlin library, Jetpack Compose Activity).
- Jetpack Compose setup ready to use. 
- Sample Espresso, Instrumentation & JUnit tests.
- 100% Gradle Kotlin DSL setup.
- CI Setup with GitHub Actions.
- Publish to **Maven Central** with Github Actions.
- Dependency versions managed via `buildSrc`.
- Kotlin Static Analysis via `detekt` and `ktlint`.
- Issues Template (bug report + feature request).
- Pull Request Template.

## Gradle Setup 🐘

This template is using [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup the build.

Dependencies are centralized inside the Gradle Version Catalog in the [libs.versions.toml](gradle/libs.versions.toml) file in the `gradle` folder.

## Static Analysis 🔍

This template is using [**detekt**](https://github.com/detekt/detekt) to analyze the source code, with the configuration that is stored in the [detekt.yml](config/detekt/detekt.yml) file (the file has been generated with the `detektGenerateConfig` task). It also uses the **detekt-formatting** plugin which includes the ktlint rules (see https://detekt.dev/docs/rules/formatting/).

## CI ⚙️

This template is using [**GitHub Actions**](https://github.com/cortinico/kotlin-android-template/actions) as CI. You don't need to setup any external service and you should have a running CI once you start using this template, just make sure that you turn on the "Read and Write permissions" on the Action Settings of your repository.

There are currently the following workflows available:
- [Validate Gradle Wrapper](.github/workflows/gradle-wrapper-validation.yml) - Will check that the gradle wrapper has a valid checksum
- [Pre Merge Checks](.github/workflows/pre-merge.yaml) - Will run the `build`, `check` and `publishToMavenLocal` tasks.

## Publishing 🚀

The template is setup to be **ready to publish** a library/artifact on a Maven Repository.

For every module you want to publish you simply have to add the `publish` plugin:

```
plugins {
    publish
}
```

### To Jitpack

If you're using [JitPack](https://jitpack.io/), you don't need any further configuration and you can just configure the repo on JitPack.

## Project Structure

The project includes three sub-projects, each in their own subdirectories:

- **`app`:** The source for the final Android application.
- **`library-android`:** The source for an Android library including UI.
- **`library-kotlin`:** The source for a UI-less Kotlin library.
- **`library-compose`:** The source for a UI library with Jetpack Compose library.

The following additional top-level directories configure & support building the app & projects:

- **`buildSrc`:** Contains shared Gradle logic as [precompiled script plugins](https://docs.gradle.org/current/userguide/custom_plugins.html#sec:precompiled_plugins)
- **`config`:** Contains the [Detekt configuration file](https://detekt.dev/docs/introduction/configurations/).
- **`gradle`:** Contains Gradle Configuration files such as the Gradle Version Catalog and the [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html).

Finally, the following hidden top-level directories provide functionality for specific development systems:

- **`.github`:** Defines the [Github Actions](https://github.com/features/actions) CI tasks and templates for new pull requests, issues, etc.
- **`.idea`:** Sets common initial project settings when the project is opened in [Android Studio](https://developer.android.com/studio) or [IntelliJ IDEA](https://www.jetbrains.com/idea/).

## Contributing 🤝

Feel free to open a issue or submit a pull request for any bugs/improvements.
