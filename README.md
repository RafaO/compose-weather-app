# Jetpack weather app

App developed for the final challenge of the compose series. In this challenge, I tried to put
effort not only in the UI but also architect the whole application in a more similar way to what I
would do in a real life project.

The app consists of a single screen displaying a week weather forecast. Upon day selection the info
will be updated showing the day's temperature and the chance of rain per hour.

It also has very simple loading and error screen to demonstrate its usage.

## Architecture overview

The app uses MVVM with state observables. The ViewModel receives the UI events, performs the
operation and emits the result through LiveData so that the UI redraws. The ViewModel receives an
use case that talks to the data provider and this way, it delivers the result. Data is hardcoded
mocking a delay when getting it.

## Testing

The app also includes basic testing as an illustration of how to key components in this architecture
can be tested: ViewModel and UseCase. Furthermore, tests for UI are also present to showcase the
instrumented tests.

## :camera_flash: Screenshots

<img src="/results/screenshot_1.png" width="260">

## Further improvements

The functionality is very limited and can be extended in several ways. Focusing on the most
immediate steps, I'd say:

- Add real data with network communication and cache
- Further UI enhancements such as adjust the theme/colors depending on the time and weather.

## License

```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
