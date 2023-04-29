function solve(worker) {
  if (worker.dizziness) {
    let level =
      worker.levelOfHydrated + worker.weight * worker.experience * 0.1;
    worker.levelOfHydrated = level;
    worker.dizziness = false;
  }

  return worker;
}

solve({ weight: 95, experience: 3, levelOfHydrated: 0, dizziness: false });
