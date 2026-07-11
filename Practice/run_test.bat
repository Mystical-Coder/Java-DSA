@echo off
cd d:\Programming\Java\DSA\Practice
g++ -o power_sequence.exe power_sequence.cpp
if errorlevel 1 (
    echo Compilation failed
    exit /b 1
)
echo Compilation successful
echo Running test...
(
    echo 6
    echo 4
    echo 4 2 16 2 8 4
) | power_sequence.exe
